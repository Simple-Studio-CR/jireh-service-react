package app.simplestudio.com.jireh.reports.dao.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ServicesProviderDao extends ReactiveMongoRepository<ServicesProvider, String> {
    Flux<ServicesProvider> findByClientId(String client, Pageable pageable);
}
