package app.simplestudio.com.jireh.reports.service.inteface;

import app.simplestudio.com.jireh.reports.documents.District;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DistrictService {

    Flux<District> findAll();

    Mono<District> findById(String id);

    Mono<District> save(District district);

    Flux<District> findDistrictByCantonId(Long cantonId);

    Flux<District> findDistrictByNumberDistrict (Long numberDistrict);

    Mono<District> findDistrictByDistrictId(Long districtId);

    Mono<Void> delete(District district);


}
