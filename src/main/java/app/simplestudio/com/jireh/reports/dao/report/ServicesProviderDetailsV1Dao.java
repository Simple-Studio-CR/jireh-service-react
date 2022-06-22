package app.simplestudio.com.jireh.reports.dao.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderDetailsV1;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ServicesProviderDetailsV1Dao extends ReactiveMongoRepository<ServicesProviderDetailsV1, String> {

    Flux<ServicesProviderDetailsV1> findServiceProviderDetailsV1ByServiceProviderId(String serviceProviderId);
}
