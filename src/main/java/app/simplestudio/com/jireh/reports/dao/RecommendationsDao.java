package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.Recommendations;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface RecommendationsDao extends ReactiveMongoRepository<Recommendations, String> {
    Flux<Recommendations> findByType(String type);
}
