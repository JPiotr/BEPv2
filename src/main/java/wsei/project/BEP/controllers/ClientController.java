package wsei.project.BEP.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wsei.project.BEP.entityes.Client;
import wsei.project.BEP.mongo.ClientRepository;
import wsei.project.BEP.services.ClientService;

import java.util.List;


@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService serv;
    @GetMapping
    @ResponseBody
    public List<Client> index() {
        return serv.getAllClients();
    }

}
