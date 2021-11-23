package project.rest.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import project.rest.spring.model.User.Usuario;
import project.rest.spring.repository.Usuario.UsuarioRepository;


import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UsuarioRepository usuarioRepository;


    public UserService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> listAll() {
        System.out.println("Service");
        return usuarioRepository.findAll();
    }

    public Usuario findByName(String name) {
        return usuarioRepository.getList().stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not Found"));
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }
}
