package app.simplestudio.com.jireh.reports.service.inteface.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderPestTypeDetail;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicesProviderPestTypeDetailService {
    Mono<ServicesProviderPestTypeDetail> save(ServicesProviderPestTypeDetail pestTypeDetail);

    Flux<ServicesProviderPestTypeDetail> findByServiceProviderId(String serviceProviderId);
}
