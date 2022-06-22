package app.simplestudio.com.jireh.reports.service.inteface;

import app.simplestudio.com.jireh.reports.documents.Neighborhood;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NeighborhoodService {

    Flux<Neighborhood> findAll();

    Mono<Neighborhood> findById(String id);

    Flux<Neighborhood> findNeighborhoodByDistrictId (Long districtId);

    Mono<Neighborhood> findNeighborhoodByNeighborhood (String neighborhood);

    Mono<Neighborhood> findNeighborhoodByNeighborhoodId (Long neighborhoodId);

    Mono<Neighborhood> save(Neighborhood neighborhood);

    Mono<Void> delete (Neighborhood neighborhood);

    Flux<Neighborhood> findNeighborhoodByNumberNeighborhood (Long numberNeighborhood);
}
