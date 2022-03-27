package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.JirehProducts;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface JirehProductsDao extends ReactiveMongoRepository<JirehProducts, String>{
	
	public Mono<JirehProducts> findByName(String name);

}
