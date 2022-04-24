package wsei.project.BEP.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wsei.project.BEP.entityes.Type;
import wsei.project.BEP.services.TypeService;

import java.util.List;

@RestController
@AllArgsConstructor
@Controller
public class TypeController {

    private final TypeService serv;

    @GetMapping("/types")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }

    @GetMapping("/types/all")
    @ResponseBody
    public List<Type> getTypes() {
        return serv.getAllTypes();
    }

    @GetMapping("types/{name}")
    @ResponseBody
    public Type getOneByName(@PathVariable String name){
        return serv.getOneByName(name);
    }
}
