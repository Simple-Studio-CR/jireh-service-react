package app.simplestudio.com.jireh.reports.service.inteface.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderDetailsV1;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicesProviderDetailsV1Service {

    Mono<ServicesProviderDetailsV1> save(ServicesProviderDetailsV1 servicesProviderDetails);

    Flux<ServicesProviderDetailsV1> findByServiceProviderId(String serviceProviderId);

    Mono<ServicesProviderDetailsV1> findById(String id);
}
