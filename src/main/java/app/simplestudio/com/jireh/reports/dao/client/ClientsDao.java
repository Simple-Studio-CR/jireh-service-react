package app.simplestudio.com.jireh.reports.dao.client;

import app.simplestudio.com.jireh.reports.documents.client.Clients;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientsDao extends ReactiveMongoRepository<Clients, String> {

    Mono<Clients> findClientsByIdentification(String identification);

    Flux<Clients> findClientsByMail(String mail);

    Flux<Clients> findClientsByContact(String contact);

    Mono<Clients> findClientsByName(String name);

    Flux<Clients> findByIdentificationOrNameOrAddressOrMail(String identification, String name, String address, String mail);
}
