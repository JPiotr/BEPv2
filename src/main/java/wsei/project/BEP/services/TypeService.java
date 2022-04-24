package wsei.project.BEP.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
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

    public Type getOneByName(String name){
        if(repo.findByName(name) == null){
            return null;
        }
        return repo.findByName(name);
    }

    public String getLogoUrlByName(String name){
        if(repo.findByName(name) == null) return null;
        return repo.findByName(name).getLogourl();
    }

    public String getIdByName(String name){
        if(repo.findByName(name) == null) return null;
        return repo.findByName(name).getId();
    }

    public Type insetNewType(String name, String logoUrl){
        return repo.insert(new Type(name,logoUrl));
    }
}
