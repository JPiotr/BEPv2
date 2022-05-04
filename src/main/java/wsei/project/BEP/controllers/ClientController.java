package wsei.project.BEP.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wsei.project.BEP.entityes.Client;
import wsei.project.BEP.entityes.DefaultStatus;
import wsei.project.BEP.entityes.Response;
import wsei.project.BEP.services.entityes.ClientService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService serv;
//    @GetMapping(
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<List<Client>> index() {
//        List<Client> x = serv.getAllClients();
//        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(x);
//    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> index() {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("clients", serv.getAllClients()))
                        .massage("Clients Data collected.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(
            value = "/{search}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> getClientByWhatever(@PathVariable String search) {
        Client x = serv.getClientsByWhatever(search);
        if(x != null) return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(x);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @RequestMapping(value = "/new",
    method = RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Client> newClient(@RequestBody Client client){
        Client x = serv.addClient(client);
        if(x != null) return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(x);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
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
