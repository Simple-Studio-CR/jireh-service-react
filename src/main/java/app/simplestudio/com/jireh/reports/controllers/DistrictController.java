package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.District;
import app.simplestudio.com.jireh.reports.service.inteface.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/district")
public class DistrictController {

    @Autowired
    private DistrictService districtService;

    @GetMapping
    Mono<ResponseEntity<Flux<District>>> findAll() {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(districtService.findAll()));
    }

    @GetMapping("/cantonid/{cantonId}")
    public Mono<ResponseEntity<Flux<District>>> findDistrictByCantonId(@PathVariable Long cantonId) {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(districtService.findDistrictByCantonId(cantonId)));
    }

    @GetMapping("/districtid/{districtId}")
    public Mono<ResponseEntity<Mono<District>>> findDistrictByDistrictId(@PathVariable Long districtId) {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(districtService.findDistrictByDistrictId(districtId)));
    }

    @GetMapping("/numberdistrict/{numberDistrict}")
    public Mono<ResponseEntity<Flux<District>>> findDistrictByNumberDistrict(@PathVariable Long numberDistrict) {
        return Mono.just(ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(districtService.findDistrictByNumberDistrict(numberDistrict)));
    }

    @PostMapping("/save")
    public Mono<ResponseEntity<Map<String, Object>>> newCanton(@Valid @RequestBody Mono<District> monoDistrict) {
        Map<String, Object> response = new HashMap<String, Object>();
        return monoDistrict.flatMap(canton -> {
            return districtService.save(canton).map(c -> {
                response.put("district", c);
                response.put("Message", "District create successfully");
                return ResponseEntity
                        .created(URI.create("/api/address/".concat(c.getId()))).body(response);
            });
        });
    }

}
