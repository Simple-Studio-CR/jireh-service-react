package app.simplestudio.com.jireh.reports.service.implementation;

import app.simplestudio.com.jireh.reports.dao.CantonDao;
import app.simplestudio.com.jireh.reports.documents.Canton;
import app.simplestudio.com.jireh.reports.service.inteface.CantonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CantonServiceImpl implements CantonService {
	
	@Autowired
	private CantonDao cantonDao;

	@Override
	public Flux<Canton> findAll() {
		// TODO Auto-generated method stub
		return cantonDao.findAll();
	}

	@Override
	public Mono<Canton> findById(String id) {
		// TODO Auto-generated method stub
		return cantonDao.findById(id);
	}

	@Override
	public Mono<Canton> findByCanton(String canton) {
		// TODO Auto-generated method stub
		return cantonDao.findByCanton(canton);
	}

	@Override
	public Mono<Canton> findCantonByCantonId(Long cantonId) {
		return cantonDao.findCantonByCantonId(cantonId);
	}

	@Override
	public Flux<Canton> findCantonByNumberCanton(Long numberCanton) {
		// TODO Auto-generated method stub
		return cantonDao.findCantonByNumberCanton(numberCanton);
	}

	@Override
	public Flux<Canton> findCantonByNumberProvince(Long numberProvince) {
		// TODO Auto-generated method stub
		return cantonDao.findCantonByNumberProvince(numberProvince);
	}

	@Override
	public Mono<Canton> save(Canton canton) {
		// TODO Auto-generated method stub
		return cantonDao.save(canton);
	}

	@Override
	public Mono<Canton> udpate(Canton canton) {
		return cantonDao.insert(canton);
	}

	@Override
	public Mono<Void> delete(Canton canton) {
		// TODO Auto-generated method stub
		return cantonDao.delete(canton);
	}

}
