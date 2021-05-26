package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.Feedlots;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface FeedlotsDao extends ReactiveMongoRepository<Feedlots, String> {

    Flux<Feedlots> findFeedlotsByIdWarehouse(String idWarehouse);

    Flux<Feedlots> findFeedlotsByIdControlReport(String idControlReport);

    Mono<Feedlots> findFeedlotsByNumberFeedlot (String numberFeedlot);
}
