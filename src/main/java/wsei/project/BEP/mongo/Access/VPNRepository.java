package wsei.project.BEP.mongo.Access;

import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Access.VPN;

public interface VPNRepository extends MongoRepository<VPN, String> {

}
