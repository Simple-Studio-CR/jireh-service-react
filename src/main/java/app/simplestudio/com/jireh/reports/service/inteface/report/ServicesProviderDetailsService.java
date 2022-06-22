package app.simplestudio.com.jireh.reports.service.inteface.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProvider;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderDetails;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicesProviderDetailsService {

    Mono<ServicesProviderDetails> save(ServicesProviderDetails servicesProviderDetails);

    Flux<ServicesProviderDetails> findByServiceProviderId(String serviceProviderId);
}
