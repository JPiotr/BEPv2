package wsei.project.BEP.services;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
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

    public Client getClientByCode(String code){
        return repo.findByCode(code);
    }

    public Client getClientByNumber(Integer number){
        return repo.findByNumber(number);
    }

    public long countClients(){
        return repo.count();
    }

    public Boolean checkExistance(Client client){
        return repo.exists(Example.of(client));
    }

    public Boolean addClient(Client client){
        if(checkExistance(client)){
            repo.insert(client);
            return true;
        }
        return false;
    }

    public Boolean addClients(List<Client> clientList){
        for (Client cl:
             clientList) {
            if(checkExistance(cl)){
                repo.insert(cl);
                return true;
            }
            return false;
        }
        return false;
    }


    //todo: Contacts Entity
    //todo: Contact types Enum
}
