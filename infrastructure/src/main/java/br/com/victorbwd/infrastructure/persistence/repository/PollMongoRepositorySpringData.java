package br.com.victorbwd.infrastructure.persistence.repository;

import br.com.victorbwd.infrastructure.persistence.document.PollDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PollMongoRepositorySpringData extends MongoRepository<PollDocument, String> {
}
