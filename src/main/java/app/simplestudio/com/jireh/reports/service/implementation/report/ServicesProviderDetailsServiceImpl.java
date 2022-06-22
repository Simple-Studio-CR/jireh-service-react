package app.simplestudio.com.jireh.reports.service.implementation.report;

import app.simplestudio.com.jireh.reports.dao.report.ServicesProviderDetailsDao;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderDetails;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicesProviderDetailsServiceImpl implements ServicesProviderDetailsService {
    @Autowired
    ServicesProviderDetailsDao providerDetailsDao;

    @Override
    public Mono<ServicesProviderDetails> save(ServicesProviderDetails servicesProviderDetails) {
        return this.providerDetailsDao.save(servicesProviderDetails);
    }

    @Override
    public Flux<ServicesProviderDetails> findByServiceProviderId(String serviceProviderId) {
        return this.providerDetailsDao.findByServiceProviderId(serviceProviderId);
    }
}
