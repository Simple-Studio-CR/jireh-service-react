package app.simplestudio.com.jireh.reports.service.implementation.report;

import app.simplestudio.com.jireh.reports.dao.report.ServicesProviderRecommendationsDao;
import app.simplestudio.com.jireh.reports.documents.report.ServicesProviderRecommendations;
import app.simplestudio.com.jireh.reports.service.inteface.report.ServicesProviderRecommendationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServicesProviderRecommendationsServiceImpl implements ServicesProviderRecommendationsService {
    @Autowired
    ServicesProviderRecommendationsDao recommendationsDao;

    @Override
    public Mono<ServicesProviderRecommendations> findById(String id) {
        return this.recommendationsDao.findById(id);
    }

    @Override
    public Mono<ServicesProviderRecommendations> save(ServicesProviderRecommendations recommendations) {
        return this.recommendationsDao.save(recommendations);
    }

    @Override
    public Flux<ServicesProviderRecommendations> findByServiceProviderId(String serviceProviderId) {
        return this.recommendationsDao.findByServiceProviderId(serviceProviderId);
    }
}
