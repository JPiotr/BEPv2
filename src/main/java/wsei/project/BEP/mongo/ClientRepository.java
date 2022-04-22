package wsei.project.BEP.mongo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Client;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client,String> {
    <S extends Client> S findByCode(String code);
    <S extends Client> S findByName(String name);
    <S extends Client> S findByNumber(Integer number);

    @Override
    <S extends Client> List<S> saveAll(Iterable<S> entities);

    @Override
    List<Client> findAll();

    @Override
    List<Client> findAll(Sort sort);

    @Override
    <S extends Client> S insert(S entity);

    @Override
    <S extends Client> List<S> insert(Iterable<S> entities);

    @Override
    <S extends Client> List<S> findAll(Example<S> example);

    @Override
    <S extends Client> List<S> findAll(Example<S> example, Sort sort);
}
