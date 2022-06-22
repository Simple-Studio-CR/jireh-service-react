package app.simplestudio.com.jireh.reports.service.inteface.client;

import app.simplestudio.com.jireh.reports.documents.client.ClientsBranchOfficeWarehouse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientsBranchOfficeWarehouseService {

    Flux<ClientsBranchOfficeWarehouse> findAll();

    Mono<ClientsBranchOfficeWarehouse> findById(String id);

    Flux<ClientsBranchOfficeWarehouse> findClientsBranchOfficeWarehouseByBranchId (String branchId);

    Mono<ClientsBranchOfficeWarehouse> findClientsBranchOfficeWarehouseByName (String name);

    Mono<ClientsBranchOfficeWarehouse> save (ClientsBranchOfficeWarehouse warehouse);

    Mono<Void> delete (ClientsBranchOfficeWarehouse warehouse);

}
