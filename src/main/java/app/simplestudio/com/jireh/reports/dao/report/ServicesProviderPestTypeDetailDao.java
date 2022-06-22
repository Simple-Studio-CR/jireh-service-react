package app.simplestudio.com.jireh.reports.dao.report;

import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderPestTypeDetail;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ServicesProviderPestTypeDetailDao extends ReactiveMongoRepository<ServicesProviderPestTypeDetail, String> {
    Flux<ServicesProviderPestTypeDetail> findByServiceProviderId(String serviceProviderId);
}
