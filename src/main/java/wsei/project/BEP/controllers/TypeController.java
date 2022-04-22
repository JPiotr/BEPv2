package wsei.project.BEP.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import wsei.project.BEP.entityes.Type;
import wsei.project.BEP.services.TypeService;

import java.util.List;

@AllArgsConstructor
@Controller
public class TypeController {

    private final TypeService serv;

    @RequestMapping("/types")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    @RequestMapping("/types/all")
    @ResponseBody
    public List<Type> getTypes() {
        return serv.getAllTypes();
    }
}
