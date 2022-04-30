package wsei.project.BEP.mongo.Access;

import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Access.Enova;

public interface EnovaRepository extends MongoRepository<Enova, String> {

}
