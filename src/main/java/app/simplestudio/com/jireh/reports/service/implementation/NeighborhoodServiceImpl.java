package app.simplestudio.com.jireh.reports.service.implementation;

import app.simplestudio.com.jireh.reports.dao.NeighborhoodDao;
import app.simplestudio.com.jireh.reports.documents.Neighborhood;
import app.simplestudio.com.jireh.reports.service.inteface.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    @Autowired
    private NeighborhoodDao dao;

    @Override
    public Flux<Neighborhood> findAll() {
        return dao.findAll();
    }

    @Override
    public Mono<Neighborhood> findById(String id) {
        return dao.findById(id);
    }

    @Override
    public Flux<Neighborhood> findNeighborhoodByDistrictId(Long districtId) {
        return dao.findNeighborhoodByDistrictId(districtId);
    }

    @Override
    public Mono<Neighborhood> findNeighborhoodByNeighborhood(String neighborhood) {
        return dao.findNeighborhoodByNeighborhood(neighborhood);
    }

    @Override
    public Mono<Neighborhood> findNeighborhoodByNeighborhoodId(Long neighborhoodId) {
        return dao.findNeighborhoodByNeighborhoodId(neighborhoodId);
    }

    @Override
    public Mono<Neighborhood> save(Neighborhood neighborhood) {
        return dao.save(neighborhood);
    }

    @Override
    public Mono<Void> delete(Neighborhood neighborhood) {
        return dao.delete(neighborhood);
    }

    @Override
    public Flux<Neighborhood> findNeighborhoodByNumberNeighborhood(Long numberNeighborhood) {
        return dao.findNeighborhoodByNumberNeighborhood(numberNeighborhood);
    }
}
