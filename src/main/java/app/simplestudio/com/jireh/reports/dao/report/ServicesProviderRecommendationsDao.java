package app.simplestudio.com.jireh.reports.dao.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderRecommendations;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ServicesProviderRecommendationsDao extends ReactiveMongoRepository<ServicesProviderRecommendations, String> {

    Flux<ServicesProviderRecommendations> findByServiceProviderId(String serviceProviderId);
}
