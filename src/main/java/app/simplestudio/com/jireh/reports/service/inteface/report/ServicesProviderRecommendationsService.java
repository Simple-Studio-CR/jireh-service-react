package app.simplestudio.com.jireh.reports.service.inteface.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderRecommendations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServicesProviderRecommendationsService {
    Mono<ServicesProviderRecommendations> findById(String id);
    Mono<ServicesProviderRecommendations> save(ServicesProviderRecommendations recommendations);

    Flux<ServicesProviderRecommendations> findByServiceProviderId(String serviceProviderId);
}
