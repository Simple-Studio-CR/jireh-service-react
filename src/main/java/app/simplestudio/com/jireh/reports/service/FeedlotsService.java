package app.simplestudio.com.jireh.reports.service;

import app.simplestudio.com.jireh.reports.documents.Feedlots;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedlotsService {

    Flux<Feedlots> findAll();

    Mono<Feedlots> findById(String id);

    Flux<Feedlots> findFeedlotsByIdWarehouse(String idWarehouse);

    Flux<Feedlots> findFeedlotsByIdControlReport(String idControlReport);

    Mono<Feedlots> findFeedlotsByNumberFeedlot (String numberFeedlot);

    Mono<Feedlots> save(Feedlots feedlots);

    Mono<Void> delete(Feedlots feedlots);

}
