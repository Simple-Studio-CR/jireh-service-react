package app.simplestudio.com.jireh.reports.service.implementation.report;

import app.simplestudio.com.jireh.reports.dao.report.ServicesProviderPestTypeDetailDao;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderPestTypeDetail;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderPestTypeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicesProviderPestTypeDetailServiceImpl implements ServicesProviderPestTypeDetailService {
    @Autowired
    ServicesProviderPestTypeDetailDao pestTypeDetailDao;

    @Override
    public Mono<ServicesProviderPestTypeDetail> save(ServicesProviderPestTypeDetail pestTypeDetail) {
        return this.pestTypeDetailDao.save(pestTypeDetail);
    }

    @Override
    public Flux<ServicesProviderPestTypeDetail> findByServiceProviderId(String serviceProviderId) {
        return this.pestTypeDetailDao.findByServiceProviderId(serviceProviderId);
    }
}
