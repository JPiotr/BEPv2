package wsei.project.BEP.controllers.Access;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wsei.project.BEP.services.Access.AccessService;

@RestController
@RequestMapping("/access")
@AllArgsConstructor
public class AccesController {
    private final AccessService serv;


}
