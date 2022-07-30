package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.JirehProducts;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface JirehProductsDao extends ReactiveMongoRepository<JirehProducts, String>{
	
	public Mono<JirehProducts> findByName(String name);

	public Flux<?> findAllByNameIsNotNull(Pageable pageable);
}
