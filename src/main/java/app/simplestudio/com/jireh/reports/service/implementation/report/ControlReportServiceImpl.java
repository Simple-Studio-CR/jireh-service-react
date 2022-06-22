package app.simplestudio.com.jireh.reports.service.implementation.report;

import app.simplestudio.com.jireh.reports.dao.report.ControlReportDao;
import app.simplestudio.com.jireh.reports.documents.report.ControlReport;
import app.simplestudio.com.jireh.reports.service.inteface.report.ControlReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class ControlReportServiceImpl implements ControlReportService {

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
    public Flux<?>  findControlReportByIdWarehouseAndEnabled(String idWarehouse, Boolean enabled, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return reportDao.findControlReportByIdWarehouseAndEnabled(idWarehouse, enabled, pageable);
    }

    @Override
    public Flux<ControlReport> findControlReportByIdClientsAndEnabled(String idClients, Boolean enabled, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return reportDao.findControlReportByIdClientsAndEnabled(idClients, enabled, pageable);
    }

    @Override
    public Flux<ControlReport> findControlReportByCreateAtAndEnabled(Date createAt, Boolean enabled) {
        return reportDao.findControlReportByCreateAtAndEnabled(createAt, enabled);
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
