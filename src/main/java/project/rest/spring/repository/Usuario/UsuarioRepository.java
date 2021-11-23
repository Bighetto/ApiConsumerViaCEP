package project.rest.spring.repository.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.rest.spring.model.User.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query(value = "select nome, cpf, email from Usuario", nativeQuery = true)
    List<Usuario> getList();
}
