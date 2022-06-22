package app.simplestudio.com.jireh.reports.service.implementation;

import app.simplestudio.com.jireh.reports.dao.RecommendationsDao;
import app.simplestudio.com.jireh.reports.documents.Recommendations;
import app.simplestudio.com.jireh.reports.service.inteface.RecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RecommendationsServiceImpl implements RecommendationsService {
    @Autowired
    RecommendationsDao recommendationsDao;

    @Override
    public Mono<Recommendations> save(Recommendations recommendations) {
        return recommendationsDao.save(recommendations);
    }

    @Override
    public Flux<Recommendations> findAll() {
        return this.recommendationsDao.findAll();
    }

    @Override
    public Flux<Recommendations> findByType(String type) {
        return this.recommendationsDao.findByType(type);
    }

    @Override
    public Mono<Recommendations> findById(String id) {
        return this.recommendationsDao.findById(id);
    }
}
