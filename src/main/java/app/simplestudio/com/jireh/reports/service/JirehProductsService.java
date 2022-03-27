package app.simplestudio.com.jireh.reports.service;

import app.simplestudio.com.jireh.reports.documents.JirehProducts;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JirehProductsService{
	
	Flux<JirehProducts> findAll();
	
	Mono<JirehProducts> findById(String id);
	
	Mono<JirehProducts> findByName(String name);
	
	Mono<JirehProducts> save(JirehProducts product);
	
	Mono<Void> delete(JirehProducts product);

}
