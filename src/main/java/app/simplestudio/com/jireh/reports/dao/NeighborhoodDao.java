package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.Neighborhood;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NeighborhoodDao extends ReactiveMongoRepository<Neighborhood, String> {

    Flux<Neighborhood> findNeighborhoodByDistrictId (Long districtId);

    Mono<Neighborhood> findNeighborhoodByNeighborhood (String neighborhood);

    Mono<Neighborhood> findNeighborhoodByNeighborhoodId (Long neighborhoodId);

    Flux<Neighborhood> findNeighborhoodByNumberNeighborhood (Long numberNeighborhood);
}
