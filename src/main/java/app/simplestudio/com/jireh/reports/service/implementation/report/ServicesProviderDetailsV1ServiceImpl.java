package app.simplestudio.com.jireh.reports.service.implementation.report;

import app.simplestudio.com.jireh.reports.dao.report.ServicesProviderDetailsV1Dao;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderDetailsV1;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderDetailsV1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicesProviderDetailsV1ServiceImpl implements ServicesProviderDetailsV1Service {

    @Autowired
    private ServicesProviderDetailsV1Dao serviceProviderDetailsV1Dao;

    @Override
    public Mono<ServicesProviderDetailsV1> save(ServicesProviderDetailsV1 servicesProviderDetails) {
        return this.serviceProviderDetailsV1Dao.save(servicesProviderDetails);
    }

    @Override
    public Flux<ServicesProviderDetailsV1> findByServiceProviderId(String serviceProviderId) {
        return this.serviceProviderDetailsV1Dao.findServiceProviderDetailsV1ByServiceProviderId(serviceProviderId);
    }
}
