package wsei.project.BEP.mongo;


import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Type;


public interface TypeRepository extends MongoRepository<Type,String> {
    <S extends Type> S findByName(String name);

}
