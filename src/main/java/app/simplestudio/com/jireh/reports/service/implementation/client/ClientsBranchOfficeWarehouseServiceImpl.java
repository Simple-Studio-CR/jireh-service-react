package app.simplestudio.com.jireh.reports.service.implementation.client;

import app.simplestudio.com.jireh.reports.dao.client.ClientsBranchOfficeWarehouseDao;
import app.simplestudio.com.jireh.reports.documents.client.ClientsBranchOfficeWarehouse;
import app.simplestudio.com.jireh.reports.service.inteface.client.ClientsBranchOfficeWarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientsBranchOfficeWarehouseServiceImpl implements ClientsBranchOfficeWarehouseService {

    @Autowired
    private ClientsBranchOfficeWarehouseDao dao;

    @Override
    public Flux<ClientsBranchOfficeWarehouse> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<ClientsBranchOfficeWarehouse> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<ClientsBranchOfficeWarehouse> findClientsBranchOfficeWarehouseByBranchId(String branchId) {
        return dao.findClientsBranchOfficeWarehouseByBranchId(branchId);
    }

    @Override
    public Mono<ClientsBranchOfficeWarehouse> findClientsBranchOfficeWarehouseByName(String name) {
        return dao.findClientsBranchOfficeWarehouseByName(name);
    }

    @Override
    public Mono<ClientsBranchOfficeWarehouse> save(ClientsBranchOfficeWarehouse warehouse) {
        return dao.save(warehouse);
    }

    @Override
    public Mono<Void> delete(ClientsBranchOfficeWarehouse warehouse) {
        return dao.delete(warehouse);
    }
}
