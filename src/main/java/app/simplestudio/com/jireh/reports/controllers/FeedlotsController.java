package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.report.Feedlots;
import app.simplestudio.com.jireh.reports.service.inteface.report.FeedlotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/feedlots")
public class FeedlotsController {

    @Autowired
    private FeedlotsService feedlotsService;

    @PostMapping("/save")
    Mono<ResponseEntity<Map<String, Object>>> newControlReport(@Valid @RequestBody Mono<Feedlots> feedlotsMono){
        Map<String, Object> response = new HashMap<>();
        return feedlotsMono.flatMap(rc->{
            if(rc.getCreateAt() == null)
                rc.setCreateAt(new Date());

            return feedlotsService.save(rc).map(r -> {
                response.put("Feedlots", r);
                response.put("Message", "Feedlots create successful");
                return ResponseEntity.created(URI.create("/api/service/feedlots".concat(rc.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response);
            });
        });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<Feedlots>> editFeedLot(@Valid @RequestBody Feedlots monoProduct,
                                                           @PathVariable(value = "id") String id) throws ParseException {
        return feedlotsService.findById(id).flatMap(p -> {
                    p.setEats(monoProduct.getEats());
                    p.setStatus(monoProduct.getStatus());
                    p.setObservations(monoProduct.getObservations());
                    return this.feedlotsService.save(p);
                }).map(p -> ResponseEntity.created(URI.create("api/clients".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/get/{idWarehouse}")
    Mono<ResponseEntity<Flux<Feedlots>>> findByWarehouse(@PathVariable(value = "idWarehouse")String idWarehouse){
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(feedlotsService.findFeedlotsByIdWarehouse(idWarehouse))
        );
    }

    @GetMapping("/get-cr/{idControlReport}")
    Mono<ResponseEntity<Flux<Feedlots>>> findByControl(@PathVariable(value = "idControlReport")String idControlReport){
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(feedlotsService.findFeedlotsByIdControlReport(idControlReport))
        );
    }
}
