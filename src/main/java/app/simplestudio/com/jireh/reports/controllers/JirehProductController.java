package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.JirehProducts;
import app.simplestudio.com.jireh.reports.service.JirehProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class JirehProductController {

    @Autowired
    JirehProductsService jirehProductsService;

    @GetMapping("/all")
    public Mono<ResponseEntity<Flux<JirehProducts>>> productsList() {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(jirehProductsService.findAll())
        );
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<JirehProducts>> viewUser(@PathVariable String id) {
        return jirehProductsService.findById(id).map(u -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{name}")
    public Mono<ResponseEntity<JirehProducts>> viewUserByName(@PathVariable String name) {
        return jirehProductsService.findByName(name).map(u -> ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(u))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> newProduct(@Valid @RequestBody Mono<JirehProducts> monoProduct) {
        Map<String, Object> response = new HashMap<>();
        return monoProduct.flatMap(products -> {
            return jirehProductsService.save(products).map(p -> {
                response.put("product", p);
                response.put("message", "Product create successful");
                return ResponseEntity.created(URI.create("api/clients".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON).body(response);
            });
        });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<JirehProducts>> editProduct(@Valid @RequestBody JirehProducts monoProduct,
                                                           @PathVariable(value = "id") String id) throws ParseException {
        return jirehProductsService.findById(id).flatMap(p -> {
                    p.setFeatures(monoProduct.getFeatures());
                    p.setActiveingredient(monoProduct.getActiveingredient());
                    p.setName(monoProduct.getName());
                    p.setSanitaryPermission(monoProduct.getSanitaryPermission());
                    return this.jirehProductsService.save(p);
                }).map(p -> ResponseEntity.created(URI.create("api/clients".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}