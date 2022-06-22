package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.Canton;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CantonDao extends ReactiveMongoRepository<Canton, String>{

	public Mono<Canton> findByCanton(String canton);

	public Mono<Canton> findCantonByCantonId (Long cantonId);

	public Flux<Canton> findCantonByNumberCanton(Long numberCanton);

	public Flux<Canton> findCantonByNumberProvince(Long numberProvince);

}
