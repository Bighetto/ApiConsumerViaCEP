package project.rest.spring.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.rest.spring.model.User.Usuario;
import project.rest.spring.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> list(){
        return ResponseEntity.ok(service.listAll());
    }

    @GetMapping(path = "/{name}")
    public ResponseEntity<Usuario> findByName(@PathVariable ("name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping
    @RequestMapping(path = "/insert")
    public Usuario insert(@RequestBody Usuario usuario){
        return service.save(usuario);
    }


}
