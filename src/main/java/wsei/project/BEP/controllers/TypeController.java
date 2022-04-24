package wsei.project.BEP.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import wsei.project.BEP.entityes.Type;
import wsei.project.BEP.services.TypeService;

import java.rmi.ServerException;
import java.util.List;

@RestController
@AllArgsConstructor
public class TypeController {

    private final TypeService serv;

    @GetMapping("/types")
    @ResponseBody
    public List<Type> index() {
        return serv.getAllTypes();
    }

    @GetMapping("types/{name}")
    @ResponseBody
    public Type getOneByName(@PathVariable String name){
        return serv.getOneByName(name);
    }

    @GetMapping("/types/{name}/url")
    @ResponseBody
    public String getUrlByName(@PathVariable String name){
        return serv.getLogoUrlByName(name);
    }

    @GetMapping("/types/{name}/id")
    @ResponseBody
    public String getIdByName(@PathVariable String name){
        return serv.getIdByName(name);
    }

//   todo:Dodanie PostMappingu
}
