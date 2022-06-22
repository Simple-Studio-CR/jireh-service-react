package app.simplestudio.com.jireh.reports.service.implementation;

import app.simplestudio.com.jireh.reports.dao.PestTypeDao;
import app.simplestudio.com.jireh.reports.documents.PestType;
import app.simplestudio.com.jireh.reports.service.inteface.PestTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PestTypeServiceImpl implements PestTypeService {
    @Autowired
    PestTypeDao pestTypeDao;

    @Override
    public Mono<PestType> save(PestType pestType) {
        return pestTypeDao.save(pestType);
    }

    @Override
    public Flux<PestType> findAll() {
        return this.pestTypeDao.findAll();
    }
}
