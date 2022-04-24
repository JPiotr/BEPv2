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

    @Override
    <S extends Acces> S save(S entity);

    @Override
    Optional<Acces> findById(String s);

    @Override
    boolean existsById(String s);

    @Override
    Iterable<Acces> findAllById(Iterable<String> strings);

    @Override
    long count();

    @Override
    void deleteById(String s);

    @Override
    void delete(Acces entity);

    @Override
    void deleteAllById(Iterable<? extends String> strings);

    @Override
    void deleteAll(Iterable<? extends Acces> entities);

    @Override
    void deleteAll();

    @Override
    <S extends Acces> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Acces> findAll();

    @Override
    List<Acces> findAll(Sort sort);

    @Override
    <S extends Acces> S insert(S entity);

    @Override
    <S extends Acces> List<S> insert(Iterable<S> entities);

    @Override
    <S extends Acces> List<S> findAll(Example<S> example);

    @Override
    <S extends Acces> List<S> findAll(Example<S> example, Sort sort);
}
