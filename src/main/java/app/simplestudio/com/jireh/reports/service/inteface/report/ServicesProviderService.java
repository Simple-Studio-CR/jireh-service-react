package app.simplestudio.com.jireh.reports.service.inteface.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicesProviderService{
    Mono<ServicesProvider> findById(String id);
    Mono<ServicesProvider> save (ServicesProvider servicesProvider);

    Flux<ServicesProvider> findByClientId(String client, int pageNo, int pageSize);
}
