package wsei.project.BEP.mongo.Access;

import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Access.*;

public interface AccesRepository extends MongoRepository<Acces,String> {


}

