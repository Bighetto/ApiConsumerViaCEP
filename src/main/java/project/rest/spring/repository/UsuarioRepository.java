package project.rest.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.rest.spring.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

}
