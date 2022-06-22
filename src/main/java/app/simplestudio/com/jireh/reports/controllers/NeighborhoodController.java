package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.Neighborhood;
import app.simplestudio.com.jireh.reports.service.inteface.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/neighborhood")
public class NeighborhoodController {

    @Autowired
    private NeighborhoodService neighborhoodService;

    @GetMapping
    public Mono<ResponseEntity<Flux<Neighborhood>>> findAll(){
        return Mono.just(ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(neighborhoodService.findAll()));
    }

    @GetMapping("/name/{neighborhood}")
    public Mono<ResponseEntity<Mono<Neighborhood>>> findNeighborhoodByNeighborhood(@PathVariable String neighborhood){
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(neighborhoodService.findNeighborhoodByNeighborhood(neighborhood)));
    }

    @GetMapping("/districtId/{neighborhoodId}")
    public Mono<ResponseEntity<Flux<Neighborhood>>> findNeighborhoodByDistrictId(@PathVariable Long neighborhoodId){
        return Mono.just(ResponseEntity.ok()
        .contentType(MediaType.APPLICATION_JSON)
        .body(neighborhoodService.findNeighborhoodByDistrictId(neighborhoodId)));
    }

    @GetMapping("/numberNeighborhood/{numberNeighborhood}")
    public Mono<ResponseEntity<Flux<Neighborhood>>> findNeighborhoodByNumberNeighborhood(@PathVariable Long numberNeighborhood){
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(neighborhoodService.findNeighborhoodByNumberNeighborhood(numberNeighborhood)));
    }

    @GetMapping("/id/{id}")
    public Mono<ResponseEntity<Mono<Neighborhood>>> findById(@PathVariable String id){
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(neighborhoodService.findById(id)));
    }

    @GetMapping("/neighborhoodId/{neighborhoodId}")
    public Mono<ResponseEntity<Mono<Neighborhood>>> findNeighborhoodByNeighborhoodId(@PathVariable Long neighborhoodId){
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(neighborhoodService.findNeighborhoodByNeighborhoodId(neighborhoodId)));
    }

    @PostMapping
    public Mono<ResponseEntity<Map<String, Object>>> newProvince(@Valid @RequestBody Mono<Neighborhood> monoNeighborhood){
        Map<String, Object> response = new HashMap<String, Object>();
        return monoNeighborhood.flatMap(neighborhood -> {
            return neighborhoodService.save(neighborhood).map(n-> {
                response.put("neighborhood", n);
                response.put("mensaje", "Neighborhood create successful");
                return ResponseEntity
                        .created(URI.create("/api/address/".concat(n.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response);
            });

        }).onErrorResume(t -> {
            return Mono.just(t).cast(WebExchangeBindException.class)
                    .flatMap(e -> Mono.just(e.getFieldErrors()))
                    .flatMapMany(Flux::fromIterable)
                    .map(fieldError -> "El campo "+fieldError.getField() + " " + fieldError.getDefaultMessage())
                    .collectList()
                    .flatMap(list -> {
                        response.put("errors", list);
                        response.put("status", HttpStatus.BAD_REQUEST.value());
                        return Mono.just(ResponseEntity.badRequest().body(response));
                    });

        });


    }
}
