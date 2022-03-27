package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.Clients;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientsDao extends ReactiveMongoRepository<Clients, String> {

    Mono<Clients> findClientsByIdentification (String identification);

    Flux<Clients> findClientsByMail (String mail);

    Flux<Clients> findClientsByContact (String contact);

    Mono<Clients> findClientsByName (String name);
}
