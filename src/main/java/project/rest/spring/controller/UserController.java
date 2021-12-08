package project.rest.spring.controller;

import org.springframework.data.repository.query.Param;
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

    @GetMapping(path = "/name/{name}")
    public ResponseEntity<Usuario> findByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PostMapping
    @RequestMapping(path = "/insert")
    public Usuario insert(@RequestBody Usuario usuario){
        return service.save(usuario);
    }

    @GetMapping(path = "/cpf/{cpf}")
    public ResponseEntity<Usuario> findByCpf(@PathVariable("cpf") String cpf){
        return ResponseEntity.ok(service.findByCpf(cpf));
    }

    @PutMapping(path = "/update/{cpf}")
    public ResponseEntity<Object> update(@RequestBody Usuario usuario, @PathVariable("cpf")String cpf){
        return service.update(usuario, cpf);
    }

    @DeleteMapping(path = "/delete/{cpf}")
    public String delete(@PathVariable("cpf")String cpf){
        service.delete(cpf);
        return "Usuario Deletado com Sucesso !!! ";
    }

    @PostMapping
    @RequestMapping(path = "/updateAddress/{cep}/cpf/{cpf}")
    public String updateAddress(@PathVariable("cep")String cep, @PathVariable("cpf")String cpf){

        Usuario user = service.findByCpf(cpf);

        service.teste(cep,cpf);

        return "Atualizado com Sucesso!!!";
    }
}