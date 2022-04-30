package wsei.project.BEP.mongo.Access;

import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Access.AnyDesk;

public interface AnyDeskRepository extends MongoRepository<AnyDesk, String> {

}
