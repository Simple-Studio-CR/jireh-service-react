package app.simplestudio.com.jireh.reports.service.inteface;

import app.simplestudio.com.jireh.reports.documents.JirehProducts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JirehProductsService{

	Flux<JirehProducts> findAll(int pageNo, int pageSize);

	Mono<Long> countAllByNameNotNull();
	
	Mono<JirehProducts> findById(String id);
	
	Mono<JirehProducts> findByName(String name);
	
	Mono<JirehProducts> save(JirehProducts product);
	
	Mono<Void> delete(JirehProducts product);

}
