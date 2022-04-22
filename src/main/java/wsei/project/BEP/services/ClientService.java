package wsei.project.BEP.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import wsei.project.BEP.entityes.Client;
import wsei.project.BEP.mongo.ClientRepository;

import java.util.List;

@AllArgsConstructor
@Service
public class ClientService {
    private final ClientRepository repo;

    public List<Client> getAllClients(){
        return repo.findAll();
    }
}
