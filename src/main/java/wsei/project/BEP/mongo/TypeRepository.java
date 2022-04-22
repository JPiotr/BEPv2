package wsei.project.BEP.mongo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Type;

import java.util.List;

public interface TypeRepository extends MongoRepository<Type,String> {
    <S extends Type> S findByName(String name);

    @Override
    <S extends Type> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Type> findAll();

    @Override
    List<Type> findAll(Sort sort);

    @Override
    <S extends Type> S insert(S entity);

    @Override
    <S extends Type> List<S> insert(Iterable<S> entities);

    @Override
    <S extends Type> List<S> findAll(Example<S> example);

    @Override
    <S extends Type> List<S> findAll(Example<S> example, Sort sort);
}
