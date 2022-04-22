package wsei.project.BEP.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@AllArgsConstructor
@Controller
public class ClientController {

    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

}
