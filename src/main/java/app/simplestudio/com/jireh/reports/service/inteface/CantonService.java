package app.simplestudio.com.jireh.reports.service.inteface;

import app.simplestudio.com.jireh.reports.documents.Canton;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CantonService {
	
	Flux<Canton> findAll();
	
	Mono<Canton> findById(String id);
	
	Mono<Canton> findByCanton(String canton);

	Mono<Canton> findCantonByCantonId (Long cantonId);
	
	Flux<Canton> findCantonByNumberCanton(Long numberCanton);
	
	Flux<Canton> findCantonByNumberProvince(Long numberProvince);
	
	Mono<Canton> save(Canton canton);

	Mono<Canton> udpate(Canton canton);
	
	Mono<Void> delete(Canton canton);

}
