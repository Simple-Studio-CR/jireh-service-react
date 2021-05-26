package app.simplestudio.com.jireh.reports.service;

import app.simplestudio.com.jireh.reports.dao.FeedlotsDao;
import app.simplestudio.com.jireh.reports.documents.Feedlots;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FeedlotsServiceImpl implements FeedlotsService{

    @Autowired
    private FeedlotsDao dao;

    @Override
    public Flux<Feedlots> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<Feedlots> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<Feedlots> findFeedlotsByIdWarehouse(String idWarehouse) {
        return dao.findFeedlotsByIdWarehouse(idWarehouse);
    }

    @Override
    public Flux<Feedlots> findFeedlotsByIdControlReport(String idControlReport) {
        return dao.findFeedlotsByIdControlReport(idControlReport);
    }

    @Override
    public Mono<Feedlots> findFeedlotsByNumberFeedlot(String numberFeedlot) {
        return dao.findFeedlotsByNumberFeedlot(numberFeedlot);
    }

    @Override
    public Mono<Feedlots> save(Feedlots feedlots) {
        return dao.save(feedlots);
    }

    @Override
    public Mono<Void> delete(Feedlots feedlots) {
        return dao.delete(feedlots);
    }
}
