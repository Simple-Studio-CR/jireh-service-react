package app.simplestudio.com.jireh.reports.dao.report;

import app.simplestudio.com.jireh.reports.documents.report.ControlReport;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.Date;

public interface ControlReportDao extends ReactiveMongoRepository<ControlReport, String> {

    Flux<?> findControlReportByIdWarehouseAndEnabled(String idWarehouse, Boolean enabled, Pageable pageable);

    Flux<ControlReport> findControlReportByIdClientsAndEnabled(String idClients, Boolean enabled, Pageable pageable);

    Flux<ControlReport> findControlReportByCreateAtAndEnabled(Date createAt, Boolean enabled);
}
