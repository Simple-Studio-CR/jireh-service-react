package app.simplestudio.com.jireh.reports.service.implementation.client;

import app.simplestudio.com.jireh.reports.dao.client.ClientsDao;
import app.simplestudio.com.jireh.reports.documents.client.Clients;
import app.simplestudio.com.jireh.reports.service.inteface.client.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientsServiceImpl implements ClientsService {

    @Autowired
    private ClientsDao clientsDao;

    @Override
    public Flux<Clients> findAll() {
        return clientsDao.findAll();
    }

    @Override
    public Mono<Clients> findById(String id) {
        return clientsDao.findById(id);
    }

    @Override
    public Mono<Clients> findClientsByIdentification(String identification) {
        return clientsDao.findClientsByIdentification(identification);
    }

    @Override
    public Flux<Clients> findClientsByMail(String mail) {
        return clientsDao.findClientsByMail(mail);
    }

    @Override
    public Flux<Clients> findClientsByContact(String contact) {
        return clientsDao.findClientsByContact(contact);
    }

    @Override
    public Mono<Clients> findClientsByName(String name) {
        return clientsDao.findClientsByName(name);
    }

    @Override
    public Mono<Clients> save(Clients clients) {
        return clientsDao.save(clients);
    }

    @Override
    public Mono<Void> delete(Clients clients) {
        return clientsDao.delete(clients);
    }
}
