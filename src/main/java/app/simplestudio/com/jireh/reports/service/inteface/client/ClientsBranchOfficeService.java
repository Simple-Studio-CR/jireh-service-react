package app.simplestudio.com.jireh.reports.service.inteface.client;

import app.simplestudio.com.jireh.reports.documents.client.ClientsBranchOffice;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientsBranchOfficeService {

    Flux<ClientsBranchOffice> findAll();

    Mono<ClientsBranchOffice> findById(String id);

    Flux<ClientsBranchOffice> findClientsBranchOfficeByClientId (String clientId);

    Flux<ClientsBranchOffice> findClientsBranchOfficeByProvinceOrCanton (String province, String canton);

    Mono<ClientsBranchOffice> findClientsBranchOfficeByName (String name);

    Mono<ClientsBranchOffice> save (ClientsBranchOffice branchOffice);

    Mono<Void> delete (ClientsBranchOffice branchOffice);
}
