package app.simplestudio.com.jireh.reports.service.implementation;

import app.simplestudio.com.jireh.reports.dao.JirehProductsDao;
import app.simplestudio.com.jireh.reports.documents.JirehProducts;
import app.simplestudio.com.jireh.reports.service.inteface.JirehProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class JirehProductsServiceImpl implements JirehProductsService {
	
	@Autowired
	JirehProductsDao productDao;

	@Override
	public Flux<JirehProducts> findAll(int pageNo, int pageSize){
		Pageable pageable = PageRequest.of(pageNo -1, pageSize);
		return productDao.findAllByNameIsNotNull(pageable);
	}

	@Override
	public Mono<Long> countAllByNameNotNull() {
		return this.productDao.countAllByNameNotNull();
	}

	@Override
	public Mono<JirehProducts> findById(String id) {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	public Mono<JirehProducts> findByName(String name) {
		return productDao.findByName(name);
	}

	@Override
	public Mono<JirehProducts> save(JirehProducts product) {
		return productDao.save(product);
	}

	@Override
	public Mono<Void> delete(JirehProducts product) {
		return productDao.delete(product);
	}

}
