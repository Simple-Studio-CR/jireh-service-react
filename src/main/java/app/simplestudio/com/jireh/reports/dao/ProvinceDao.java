package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.Province;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ProvinceDao extends ReactiveMongoRepository<Province, String>{
	
	public Mono<Province> findByProvince(String province);
	
	public Mono<Province> findByNumberProvince(Long numberProvince);

}
