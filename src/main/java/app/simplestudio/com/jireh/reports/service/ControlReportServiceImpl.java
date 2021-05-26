package app.simplestudio.com.jireh.reports.service;

import app.simplestudio.com.jireh.reports.dao.ControlReportDao;
import app.simplestudio.com.jireh.reports.documents.ControlReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ControlReportServiceImpl implements ControlReportService{

    @Autowired
    private ControlReportDao reportDao;

    @Override
    public Flux<ControlReport> findAll() {
        return reportDao.findAll();
    }

    @Override
    public Mono<ControlReport> findById(String id) {
        return reportDao.findById(id);
    }

    @Override
    public Flux<ControlReport> findControlReportByIdWarehouse(String idWarehouse) {
        return reportDao.findControlReportByIdWarehouse(idWarehouse);
    }

    @Override
    public Flux<ControlReport> findControlReportByIdClients(String idClients) {
        return reportDao.findControlReportByIdClients(idClients);
    }

    @Override
    public Flux<ControlReport> findControlReportByMonth(Integer month) {
        return reportDao.findControlReportByMonth(month);
    }

    @Override
    public Flux<ControlReport> findControlReportByWeek(Integer week) {
        return reportDao.findControlReportByWeek(week);
    }

    @Override
    public Flux<ControlReport> findControlReportByYear(Integer year) {
        return reportDao.findControlReportByYear(year);
    }

    @Override
    public Mono<ControlReport> save(ControlReport controlReport) {
        return reportDao.save(controlReport);
    }

    @Override
    public Mono<Void> delete(ControlReport controlReport) {
        return reportDao.delete(controlReport);
    }
}
