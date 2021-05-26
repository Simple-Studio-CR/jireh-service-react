package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.ControlReport;
import app.simplestudio.com.jireh.reports.service.ControlReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/controlReport")
public class ControlReportController {

    @Autowired
    private ControlReportService reportService;

    @PostMapping
    Mono<ResponseEntity<Map<String, Object>>> newControlReport(@Valid @RequestBody Mono<ControlReport> controlReportMono){
        Map<String, Object> response = new HashMap<>();
        return controlReportMono.flatMap(rc->{
            if(rc.getCreateAt() == null)
                rc.setCreateAt(new Date());

            return reportService.save(rc).map(r -> {
                response.put("Control Report", r);
                response.put("Message", "Control Report create successful");
                return ResponseEntity.created(URI.create("/api/reports/controlReport".concat(rc.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response);
            });
        });
    }
}
