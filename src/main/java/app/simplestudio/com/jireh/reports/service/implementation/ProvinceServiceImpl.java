package app.simplestudio.com.jireh.reports.service.implementation;

import app.simplestudio.com.jireh.reports.dao.ProvinceDao;
import app.simplestudio.com.jireh.reports.documents.Province;
import app.simplestudio.com.jireh.reports.service.inteface.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProvinceServiceImpl implements ProvinceService {
	
	@Autowired
	private ProvinceDao provinceDao;

	@Override
	public Flux<Province> findAll() {
		// TODO Auto-generated method stub
		return provinceDao.findAll();
	}

	@Override
	public Mono<Province> findById(String id) {
		// TODO Auto-generated method stub
		return provinceDao.findById(id);
	}

	@Override
	public Mono<Province> findByProvince(String province) {
		// TODO Auto-generated method stub
		return provinceDao.findByProvince(province);
	}

	@Override
	public Mono<Province> findByNumberProvince(Long numberProvince) {
		// TODO Auto-generated method stub
		return provinceDao.findByNumberProvince(numberProvince);
	}

	@Override
	public Mono<Province> save(Province province) {
		// TODO Auto-generated method stub
		return provinceDao.save(province);
	}

	@Override
	public Mono<Void> delete(Province province) {
		// TODO Auto-generated method stub
		return provinceDao.delete(province);
	}

}
