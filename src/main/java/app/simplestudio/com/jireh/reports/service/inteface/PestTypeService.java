package app.simplestudio.com.jireh.reports.service.inteface;

import app.simplestudio.com.jireh.reports.documents.PestType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PestTypeService {
    Mono<PestType> save(PestType pestType);

    Flux<PestType> findAll();
}
