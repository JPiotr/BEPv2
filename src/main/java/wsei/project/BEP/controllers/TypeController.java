package wsei.project.BEP.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wsei.project.BEP.entityes.Type;
import wsei.project.BEP.services.entityes.TypeService;

import java.util.List;

@RestController
@RequestMapping("/types")
@AllArgsConstructor
public class TypeController {

    private final TypeService serv;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Type>> index() {
        List<Type> x = serv.getAllTypes();
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(x);
    }

    @RequestMapping(value = "/{name}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Type> getOneByName(@PathVariable String name){
        Type x = serv.getOneByName(name);
        if(x != null) return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(x);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "/{name}/url",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getUrlByName(@PathVariable String name){
        String url = serv.getLogoUrlByName(name);
        if(url != null) return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(url);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "/{name}/id",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<String> getIdByName(@PathVariable String name){
        String id = serv.getIdByName(name);
        if(id != null) return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.TEXT_PLAIN).body(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
//todo: Delete method
    @RequestMapping(
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseBody
    public ResponseEntity<Type> deleteType(Type type){
        return null;
    }

    @RequestMapping(value = "/new",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> newType(@RequestBody Type type){
        Type x = serv.insetNewType(type.getName(), type.getLogourl());
        if(x != null) return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(x);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @RequestMapping(value = "/new",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Type> addNewType(@RequestBody Type type){
        Type x = serv.addNewType(type);
        if(x != null) return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(x);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
}
