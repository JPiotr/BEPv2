package wsei.project.BEP.mongo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import wsei.project.BEP.entityes.Acces;
import wsei.project.BEP.entityes.Type;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface AccesRepository extends MongoRepository<Acces,String> {


}
