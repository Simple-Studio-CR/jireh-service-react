package app.simplestudio.com.jireh.reports.service.inteface.report;

import app.simplestudio.com.jireh.reports.documents.report.ControlReport;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

public interface ControlReportService {

    Flux<ControlReport> findAll();

    Mono<ControlReport> findById(String id);

    Flux<?> findControlReportByIdWarehouseAndEnabled(String idWarehouse, Boolean enabled, int pageNo, int pageSize);

    Flux<ControlReport> findControlReportByIdClientsAndEnabled(String idClients, Boolean enabled, int pageNo, int pageSize);

    Flux<ControlReport> findControlReportByCreateAtAndEnabled(Date createAt, Boolean enabled);

    Mono<ControlReport> save(ControlReport controlReport);

    Mono<Void> delete(ControlReport controlReport);
}
