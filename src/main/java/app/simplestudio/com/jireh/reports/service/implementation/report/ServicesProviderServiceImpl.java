package app.simplestudio.com.jireh.reports.service.implementation.report;

import app.simplestudio.com.jireh.reports.dao.report.ServicesProviderDao;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProvider;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicesProviderServiceImpl implements ServicesProviderService {

    @Autowired
    ServicesProviderDao servicesProviderDao;

    @Override
    public Mono<ServicesProvider> save(ServicesProvider servicesProvider) {
        return this.servicesProviderDao.save(servicesProvider);
    }

    @Override
    public Flux<ServicesProvider> findByClientId(String client, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo -1, pageSize);
        return this.servicesProviderDao.findByClientId(client, pageable);
    }

}
