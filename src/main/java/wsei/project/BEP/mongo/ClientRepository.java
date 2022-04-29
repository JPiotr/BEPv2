package wsei.project.BEP.mongo;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import wsei.project.BEP.entityes.Client;
import wsei.project.BEP.entityes.DefaultStatus;

import java.util.List;

public interface ClientRepository extends MongoRepository<Client,String> {
    <S extends Client> S findByCode(String code);
    <S extends Client> S findByName(String name);
    <S extends Client> S findByNumber(Integer number);

    <E extends Client> List<E> findClientsByStatus(DefaultStatus status);

}
