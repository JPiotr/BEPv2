package wsei.project.BEP.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsei.project.BEP.entityes.Type;
import wsei.project.BEP.mongo.TypeRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class TypeService {
    private final TypeRepository repo;

    public List<Type> getAllTypes(){
        return repo.findAll();
    }
}
