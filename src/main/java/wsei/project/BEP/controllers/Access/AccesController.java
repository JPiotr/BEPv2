package wsei.project.BEP.controllers.Access;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import wsei.project.BEP.entityes.Access.Access;
import wsei.project.BEP.entityes.Client;
import wsei.project.BEP.entityes.Response;
import wsei.project.BEP.services.Access.AccessService;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/access")
@AllArgsConstructor
public class AccesController {
    private final AccessService serv;

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> index() {

        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("accesses", serv.getAll()))
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
                        .data(Map.of("access", serv.getById(search)))
                        .massage("Clients Data collected.")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

//    @RequestMapping(
//            value = "/update",
//            method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Response> updateClient(@RequestBody @Validated Access access){
//        return ResponseEntity.ok(
//                Response.builder()
//                        .timestamp(LocalDateTime.now())
//                        .data(Map.of("client", serv.(access)))
//                        .massage("New Client created.")
//                        .status(HttpStatus.CREATED)
//                        .statusCode(HttpStatus.CREATED.value())
//                        .build()
//        );
//    }
}
