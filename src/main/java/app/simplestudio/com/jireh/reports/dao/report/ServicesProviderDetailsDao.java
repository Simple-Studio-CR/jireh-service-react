package app.simplestudio.com.jireh.reports.dao.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderDetails;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ServicesProviderDetailsDao extends ReactiveMongoRepository<ServicesProviderDetails, String> {
    Flux<ServicesProviderDetails> findByServiceProviderId(String serviceProviderId);
}
