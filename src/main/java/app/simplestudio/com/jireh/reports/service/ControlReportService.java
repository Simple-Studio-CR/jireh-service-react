package app.simplestudio.com.jireh.reports.service;

import app.simplestudio.com.jireh.reports.documents.ControlReport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ControlReportService {

    Flux<ControlReport> findAll();

    Mono<ControlReport> findById(String id);

    Flux<ControlReport> findControlReportByIdWarehouse(String idWarehouse);

    Flux<ControlReport> findControlReportByIdClients(String idClients);

    Flux<ControlReport> findControlReportByMonth(Integer month);

    Flux<ControlReport> findControlReportByWeek(Integer week);

    Flux<ControlReport> findControlReportByYear(Integer year);

    Mono<ControlReport> save(ControlReport controlReport);

    Mono<Void> delete(ControlReport controlReport);
}
