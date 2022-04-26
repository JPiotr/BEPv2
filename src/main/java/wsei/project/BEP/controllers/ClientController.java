package wsei.project.BEP.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wsei.project.BEP.entityes.Client;
import wsei.project.BEP.entityes.DefaultStatus;
import wsei.project.BEP.mongo.ClientRepository;
import wsei.project.BEP.services.ClientService;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService serv;
    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> index() {
        List<Client> x = serv.getAllClients();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(x);
    }

    //todo:Wypełnienie metody w serwisie
    @GetMapping(
            value = "/{search}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Client>> getClientByWhatever(@PathVariable String search) {
        List<Client> x = serv.getClientsByWhatever(search);
        if(x != null) return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(x);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @RequestMapping(value = "/new",
    method = RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> newClient(@RequestBody Client client){
        Client x = serv.addClient(client);
        if(x != null) return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(x);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    @RequestMapping(value = "/update",
                    method = RequestMethod.PUT,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClientByCode(@RequestParam(defaultValue = "!00000") String code,
                                     @RequestParam(defaultValue = "3") Integer status){
        Client x;
        switch (status){
            case 1:
                x = serv.changeStatusByCode(code,DefaultStatus.OK);
                break;
            case 2:
                x = serv.changeStatusByCode(code,DefaultStatus.BAD);
                break;
            case 3:
                x = serv.changeStatusByCode(code,DefaultStatus.CHANGED);
                break;
            case 4:
                x = serv.changeStatusByCode(code,DefaultStatus.UNKNOWN);
                break;
            default: return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(x == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON).body(x);
    }

    @RequestMapping(value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        Client x = serv.changeClient(client);
        if(x != null) return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(x);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
