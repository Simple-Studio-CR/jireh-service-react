package app.simplestudio.com.jireh.reports.service.inteface;

import app.simplestudio.com.jireh.reports.documents.Recommendations;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface RecommendationsService {
    Mono<Recommendations> save(Recommendations recommendations);

    Flux<Recommendations> findAll();

    Flux<Recommendations> findByType(String type);

    Mono<Recommendations> findById(String id);
}
