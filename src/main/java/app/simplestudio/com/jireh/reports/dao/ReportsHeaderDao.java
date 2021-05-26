package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.ReportsHeader;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReportsHeaderDao extends ReactiveMongoRepository<ReportsHeader, String> {
}
