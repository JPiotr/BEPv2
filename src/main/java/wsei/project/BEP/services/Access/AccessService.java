package wsei.project.BEP.services.Access;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsei.project.BEP.entityes.Access.Access;
import wsei.project.BEP.mongo.Access.AccesRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AccessService {
    private final AccesRepository repo;

    public List<Access> getAll(){
        return repo.findAll();
    }

    public Optional<Access> getById(String id){
        return repo.findById(id);
    }

}
