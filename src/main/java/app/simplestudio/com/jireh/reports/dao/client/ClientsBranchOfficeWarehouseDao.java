package app.simplestudio.com.jireh.reports.dao.client;

import app.simplestudio.com.jireh.reports.documents.client.ClientsBranchOfficeWarehouse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientsBranchOfficeWarehouseDao extends ReactiveMongoRepository<ClientsBranchOfficeWarehouse, String> {

    Flux<ClientsBranchOfficeWarehouse> findClientsBranchOfficeWarehouseByBranchId (String branchId);

    Mono<ClientsBranchOfficeWarehouse> findClientsBranchOfficeWarehouseByName (String name);
}
