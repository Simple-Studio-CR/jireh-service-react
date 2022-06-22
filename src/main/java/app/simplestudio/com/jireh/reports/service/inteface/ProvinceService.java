package app.simplestudio.com.jireh.reports.service.inteface;

import app.simplestudio.com.jireh.reports.documents.Province;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProvinceService {
	
	Flux<Province> findAll();
	
	Mono<Province> findById(String id);
	
	Mono<Province> findByProvince(String province);
	
	Mono<Province> findByNumberProvince(Long numberProvince);
	
	Mono<Province> save(Province province);
	
	Mono<Void> delete(Province province);

}
