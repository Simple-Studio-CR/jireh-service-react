package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.District;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DistrictDao extends ReactiveMongoRepository<District, String> {

    Flux<District> findDistrictByCantonId(Long cantonId);

    Mono<District> findDistrictByDistrictId (Long districtId);

    Flux<District> findDistrictByNumberDistrict (Long numberDistrict);
}
