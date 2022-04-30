package wsei.project.BEP.mongo.Access;

import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Access.TeamViewer;

public interface TVRepository extends MongoRepository<TeamViewer, String> {

}
