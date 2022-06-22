package app.simplestudio.com.jireh.reports.service.implementation.client;

import app.simplestudio.com.jireh.reports.dao.client.ClientsBranchOfficeDao;
import app.simplestudio.com.jireh.reports.documents.client.ClientsBranchOffice;
import app.simplestudio.com.jireh.reports.service.inteface.client.ClientsBranchOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientsBranchOfficeServiceImpl implements ClientsBranchOfficeService {

    @Autowired
    private ClientsBranchOfficeDao dao;

    @Override
    public Flux<ClientsBranchOffice> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<ClientsBranchOffice> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<ClientsBranchOffice> findClientsBranchOfficeByClientId(String clientId) {
        return dao.findAllByClientId(clientId);
    }

    @Override
    public Flux<ClientsBranchOffice> findClientsBranchOfficeByProvinceOrCanton(String province, String canton) {
        return dao.findClientsBranchOfficeByProvinceOrCanton(province, canton);
    }

    @Override
    public Mono<ClientsBranchOffice> findClientsBranchOfficeByName(String name) {
        return dao.findClientsBranchOfficeByName(name);
    }

    @Override
    public Mono<ClientsBranchOffice> save(ClientsBranchOffice branchOffice) {
        return dao.save(branchOffice);
    }

    @Override
    public Mono<Void> delete(ClientsBranchOffice branchOffice) {
        return dao.delete(branchOffice);
    }
}
