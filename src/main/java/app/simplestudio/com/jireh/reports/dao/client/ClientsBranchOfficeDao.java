package app.simplestudio.com.jireh.reports.dao.client;

import app.simplestudio.com.jireh.reports.documents.client.ClientsBranchOffice;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientsBranchOfficeDao extends ReactiveMongoRepository<ClientsBranchOffice, String> {

    Flux<ClientsBranchOffice> findAllByClientId (String clientId);

    Flux<ClientsBranchOffice> findClientsBranchOfficeByProvinceOrCanton (String province, String canton);

    Mono<ClientsBranchOffice> findClientsBranchOfficeByName (String name);
}
