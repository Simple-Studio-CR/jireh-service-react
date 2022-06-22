package app.simplestudio.com.jireh.reports.service.implementation;

import app.simplestudio.com.jireh.reports.dao.DistrictDao;
import app.simplestudio.com.jireh.reports.documents.District;
import app.simplestudio.com.jireh.reports.service.inteface.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    private DistrictDao districtDao;

    @Override
    public Flux<District> findAll() {
        return districtDao.findAll();
    }

    @Override
    public Mono<District> findById(String id) {
        return districtDao.findById(id);
    }

    @Override
    public Mono<District> save(District district) {
        return districtDao.save(district);
    }

    @Override
    public Flux<District> findDistrictByCantonId(Long cantonId) {
        return districtDao.findDistrictByCantonId(cantonId);
    }

    @Override
    public Flux<District> findDistrictByNumberDistrict(Long numberDistrict) {
        return districtDao.findDistrictByNumberDistrict(numberDistrict);
    }

    @Override
    public Mono<District> findDistrictByDistrictId(Long districtId) {
        return districtDao.findDistrictByDistrictId(districtId);
    }

    @Override
    public Mono<Void> delete(District district) {
        return districtDao.delete(district);
    }
}
