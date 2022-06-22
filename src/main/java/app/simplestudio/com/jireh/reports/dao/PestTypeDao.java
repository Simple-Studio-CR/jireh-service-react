package app.simplestudio.com.jireh.reports.dao;

import app.simplestudio.com.jireh.reports.documents.PestType;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PestTypeDao extends ReactiveMongoRepository<PestType, String> {
}
