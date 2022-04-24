package wsei.project.BEP.mongo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import wsei.project.BEP.entityes.Acces;
import wsei.project.BEP.entityes.Type;

import java.util.List;
import java.util.function.Function;

public interface AccesRepository extends MongoRepository<Acces,String> {
    //<S extends Acces> S findById(Long id);
    List<Acces> findAllByType(Type type);

    @Override
    <S extends Acces> S save(S entity);

    @Override
    long count();

    @Override
    void delete(Acces entity);

    @Override
    void deleteAll(Iterable<? extends Acces> entities);

    @Override
    <S extends Acces> long count(Example<S> example);

    @Override
    <S extends Acces> boolean exists(Example<S> example);

    @Override
    <S extends Acces, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

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
