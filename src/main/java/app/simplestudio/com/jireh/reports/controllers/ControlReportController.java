package app.simplestudio.com.jireh.reports.controllers;

import app.simplestudio.com.jireh.reports.documents.report.ControlReport;
import app.simplestudio.com.jireh.reports.service.inteface.report.ControlReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.net.URI;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/controlReport")
public class ControlReportController {

    @Autowired
    private ControlReportService reportService;

    @PostMapping("/save")
    Mono<ResponseEntity<Map<String, Object>>> newControlReport(@Valid @RequestBody Mono<ControlReport> controlReportMono){
        Map<String, Object> response = new HashMap<>();
        return controlReportMono.flatMap(rc->{
            if(rc.getCreateAt() == null)
                rc.setCreateAt(new Date());

            return reportService.save(rc).map(r -> {
                response.put("ControlReport", r);
                response.put("Message", "Control Report create successful");
                return ResponseEntity.created(URI.create("/api/reports/controlReport".concat(rc.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(response);
            });
        });
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<ControlReport>> editFeedLot(@Valid @RequestBody ControlReport monoProduct,
                                                      @PathVariable(value = "id") String id) throws ParseException {
        return reportService.findById(id).flatMap(p -> {
                    p.setEndTime(monoProduct.getEndTime());
                    p.setTotal(monoProduct.getTotal());
                    p.setStartTime(monoProduct.getStartTime());
                    return this.reportService.save(p);
                }).map(p -> ResponseEntity.created(URI.create("api/clients".concat(p.getId())))
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(p))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/get/{idWarehouse}/{enabled}/{pageNo}/{pageSize}")
    Flux<?> findByControl(@PathVariable(value = "idWarehouse")String idWarehouse,
                                      @PathVariable(value = "enabled")Boolean enabled,
                                      @PathVariable(value = "pageNo")int pageNo,
                                      @PathVariable(value = "pageSize")int pageSize){
        return reportService.findControlReportByIdWarehouseAndEnabled(idWarehouse, enabled, pageNo, pageSize);
    }

    @GetMapping("/get-client/{idClient}/{enabled}/{pageNo}/{pageSize}")
    Flux<?> findByClient(@PathVariable(value = "idClient")String idClient,
                          @PathVariable(value = "enabled")Boolean enabled,
                          @PathVariable(value = "pageNo")int pageNo,
                          @PathVariable(value = "pageSize")int pageSize){
        return reportService.findControlReportByIdClientsAndEnabled(idClient, enabled, pageNo, pageSize);
    }
}
