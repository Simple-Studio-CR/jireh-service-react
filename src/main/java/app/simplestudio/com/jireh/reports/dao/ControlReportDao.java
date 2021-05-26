package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.ControlReport;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ControlReportDao extends ReactiveMongoRepository<ControlReport, String> {

    Flux<ControlReport> findControlReportByIdWarehouse(String idWarehouse);

    Flux<ControlReport> findControlReportByIdClients(String idClients);

    Flux<ControlReport> findControlReportByMonth(Integer month);

    Flux<ControlReport> findControlReportByWeek(Integer week);

    Flux<ControlReport> findControlReportByYear(Integer year);
}
