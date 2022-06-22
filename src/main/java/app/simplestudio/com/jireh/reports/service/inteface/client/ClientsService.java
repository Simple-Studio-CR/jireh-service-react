package app.simplestudio.com.jireh.reports.service.inteface.client;

import app.simplestudio.com.jireh.reports.documents.client.Clients;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientsService {

    Flux<Clients> findAll();

    Mono<Clients> findById(String id);

    Mono<Clients> findClientsByIdentification (String identification);

    Flux<Clients> findClientsByMail (String mail);

    Flux<Clients> findClientsByContact (String contact);

    Mono<Clients> findClientsByName (String name);

    Mono<Clients> save (Clients clients);

    Mono<Void> delete (Clients clients);
}
