package app.simplestudio.com.jireh.reports.service.inteface;

import app.simplestudio.com.jireh.reports.documents.JirehProducts;
import org.springframework.data.domain.Page;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JirehProductsService{

	Flux<Page<?>> findAllPageable(int pageNo, int pageSize);
	
	Mono<JirehProducts> findById(String id);
	
	Mono<JirehProducts> findByName(String name);
	
	Mono<JirehProducts> save(JirehProducts product);
	
	Mono<Void> delete(JirehProducts product);

}
