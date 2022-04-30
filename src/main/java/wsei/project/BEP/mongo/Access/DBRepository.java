package wsei.project.BEP.mongo.Access;

import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Access.DB;

public interface DBRepository extends MongoRepository<DB, String> {

}
