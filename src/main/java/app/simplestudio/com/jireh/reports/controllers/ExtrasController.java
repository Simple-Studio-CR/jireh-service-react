package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.PestType;
import app.simplestudio.com.jireh.reports.documents.Recommendations;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderRecommendations;
import app.simplestudio.com.jireh.reports.service.inteface.PestTypeService;
import app.simplestudio.com.jireh.reports.service.inteface.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/extras")
public class ExtrasController {

    @Autowired
    RecommendationsService recommendationsService;

    @Autowired
    PestTypeService pestTypeService;

    @PostMapping("/save-recommendations")
    Mono<ResponseEntity<Map<String, Object>>> saveRecommendations(@Valid @RequestBody Mono<Recommendations> recommendationsMono) {
        Map<String, Object> response = new HashMap<>();
        return recommendationsMono.flatMap(recommendations -> {
            return this.recommendationsService.save(recommendations).map(r -> {
                response.put("Recommendations", r);
                response.put("message", "Recommendations create successful");
                return ResponseEntity.created(URI.create("api/clients".concat(r.getId())))
                        .contentType(MediaType.APPLICATION_JSON).body(response);
            });
        });
    }

    @PostMapping("/save-pest")
    Mono<ResponseEntity<Map<String, Object>>> savePestType(@Valid @RequestBody Mono<PestType> pestTypeMono) {
        Map<String, Object> response = new HashMap<>();
        return pestTypeMono.flatMap(pestType -> {
            return this.pestTypeService.save(pestType).map(r -> {
                response.put("PestType", r);
                response.put("message", "Pest create successful");
                return ResponseEntity.created(URI.create("api/clients".concat(r.getId())))
                        .contentType(MediaType.APPLICATION_JSON).body(response);
            });
        });
    }

    @GetMapping("/get-recommendation")
    public ResponseEntity<?> findRecommendations(){
        return ResponseEntity.status(200).body(this.recommendationsService.findAll());
    }

    @GetMapping("/get-recommendation-type/{type}")
    public ResponseEntity<?> findRecommendationsByType(@PathVariable(value = "type") String type){
        return ResponseEntity.ok(this.recommendationsService.findByType(type));
    }

    @GetMapping("/get-recommendation/{id}")
    public ResponseEntity<?> findRecommendationsById(@PathVariable(value = "id") String id){
        return ResponseEntity.status(200).body(this.recommendationsService.findById(id));
    }

    @GetMapping("/get-pest")
    public ResponseEntity<?> findPestType(){
        return ResponseEntity.status(200).body(this.pestTypeService.findAll());
    }

}
