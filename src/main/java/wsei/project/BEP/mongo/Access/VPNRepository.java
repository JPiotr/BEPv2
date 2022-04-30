package wsei.project.BEP.mongo.Access;

import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Access.VPN;

public interface VPNRepository extends MongoRepository<VPN, String> {
<S extends  VPN> S findByName(String name);
<S extends  VPN> S findByIpaddress(String ip);

}
