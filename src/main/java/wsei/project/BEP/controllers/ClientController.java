package wsei.project.BEP.controllers;

import com.mongodb.lang.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wsei.project.BEP.entityes.Client;
import wsei.project.BEP.entityes.DefaultStatus;
import wsei.project.BEP.entityes.Response;
import wsei.project.BEP.services.entityes.ClientService;

import java.time.LocalDateTime;
import java.util.Map;


@RestController
@RequestMapping("/clients")
@AllArgsConstructor
public class ClientController {
    private final ClientService serv;

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
    public ResponseEntity<Response> getClientByWhatever(@PathVariable String search) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("clients", serv.getClientsByWhatever(search)))
                        .massage("Clients Data collected.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @RequestMapping(
            value = "/find",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> getClientsByNameOrCode(@RequestParam @DefaultValue("") String search) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("clients", serv.getClientsByNameOrCode(search, search)))
                        .massage("Clients Find.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @RequestMapping(
            value = "/new",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> newClient(@RequestBody @Validated Client client){
            return ResponseEntity.ok(
                    Response.builder()
                            .timestamp(LocalDateTime.now())
                            .data(Map.of("client", serv.addClient(client)))
                            .massage("New Client created.")
                            .status(HttpStatus.CREATED)
                            .statusCode(HttpStatus.CREATED.value())
                            .build()
            );
    }

    @RequestMapping(
                    value = "/status",
                    method = RequestMethod.PUT,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateClientStatusByCode(@RequestParam(defaultValue = "!00000") String code,
                                     @RequestParam(defaultValue = "3") Integer status){
        return switch (status) {
            case 1 -> ResponseEntity.ok(
                    Response.builder()
                            .timestamp(LocalDateTime.now())
                            .data(Map.of("client", serv.changeStatusByCode(code, DefaultStatus.OK)))
                            .massage("Updated client status.")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
            case 2 -> ResponseEntity.ok(
                    Response.builder()
                            .timestamp(LocalDateTime.now())
                            .data(Map.of("client", serv.changeStatusByCode(code, DefaultStatus.BAD)))
                            .massage("Updated client status.")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
            case 3 -> ResponseEntity.ok(
                    Response.builder()
                            .timestamp(LocalDateTime.now())
                            .data(Map.of("client", serv.changeStatusByCode(code, DefaultStatus.CHANGED)))
                            .massage("Updated client status.")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
            case 4 -> ResponseEntity.ok(
                    Response.builder()
                            .timestamp(LocalDateTime.now())
                            .data(Map.of("client", serv.changeStatusByCode(code, DefaultStatus.UNKNOWN)))
                            .massage("Updated client status.")
                            .status(HttpStatus.OK)
                            .statusCode(HttpStatus.OK.value())
                            .build()
            );
            default -> ResponseEntity.badRequest().build();
        };
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> updateClient(@RequestBody @Validated Client client){
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("client", serv.changeClient(client)))
                        .massage("New Client created.")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }
}
