package wsei.project.BEP.services.Access;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsei.project.BEP.mongo.Access.AccesRepository;
import wsei.project.BEP.mongo.ClientRepository;

@AllArgsConstructor
@Service
public class AccessService {
    private final AccesRepository repo;


}
