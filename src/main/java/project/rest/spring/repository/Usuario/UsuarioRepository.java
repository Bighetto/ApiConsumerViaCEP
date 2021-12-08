package project.rest.spring.repository.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import project.rest.spring.model.User.Usuario;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    @Query(value = "select nome, cpf, email from Usuario", nativeQuery = true)
    List<Usuario> getList();


    @Modifying
    @Transactional
    @Query(value = "update Usuario set nome = :newNome, email = :newEmail \n" +
            "where cpf = :cpf ",nativeQuery = true)
    void update(@Param("newNome") String newNome,
                @Param("newEmail") String newEmail,
                @Param("cpf") String cpf);

    @Modifying
    @Transactional
    @Query(value = "delete FROM Usuario WHERE cpf = :cpf",nativeQuery = true)
    void deleteUser(@Param("cpf") String cpf);

    @Modifying
    @Transactional
    @Query(value = "update Usuario set cep = :cep, logradouro = :logradouro , \n" +
            "complemento = :complemento , bairro = :bairro , localidade = :localidade,\n" +
            "uf = :uf WHERE cpf = :cpf",nativeQuery = true)
    void updateAddress(@Param("cep") String cep,
                       @Param("logradouro") String logradouro,
                       @Param("complemento") String complemento,
                       @Param("bairro") String bairro,
                       @Param("localidade")String localidade,
                       @Param("uf")String uf,
                       @Param("cpf")String cpf);
}
