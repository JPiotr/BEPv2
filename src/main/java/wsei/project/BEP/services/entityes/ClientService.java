package wsei.project.BEP.services.entityes;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import wsei.project.BEP.entityes.Client;
import wsei.project.BEP.entityes.DefaultStatus;
import wsei.project.BEP.mongo.ClientRepository;

import java.time.LocalDate;
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

    public Boolean CheckExistance(Client client){
        return repo.exists(Example.of(client));
    }

    public Client getClientsByWhatever(String whatever){
        Client tCode = repo.findByCode(whatever);
        Client tName = repo.findByName(whatever);
        if(tCode != null) return tCode;
        if(tName != null) return tName;

        return null;
    }

    public Client addClient(Client client){
        if(!CheckExistance(client)){
            return repo.insert(client);
        }
        return null;
    }

    public Client changeClient(Client client){
        if(!CheckExistance(client)){
            return repo.save(client);
        }
        return null;
    }

    public Client changeStatusByCode(String code, DefaultStatus status){
        Client newc = repo.findByCode(code);

        if(newc == null) return null;

        if(status != newc.getStatus()){
            newc.setModyfyDate(LocalDate.now());
            newc.setStatus(status);
            repo.save(newc);
            return newc;
        }
        else{
            return null;
        }
    }

    public Client addBrClientToClient(Client brClient, Client client){
        Client x = repo.findByCode(client.getCode());
        if(x != null){
            x.getBrClients().add(brClient);
            repo.save(x);
            return x;
        }
        else return null;
    }
    //todo: Contacts Entity
}
