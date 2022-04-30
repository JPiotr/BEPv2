package wsei.project.BEP.mongo.Access;

import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Access.RDP;

public interface RDPRepository extends MongoRepository<RDP, String> {

}
