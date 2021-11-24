package project.rest.spring.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import project.rest.spring.HttpConsumer.ViaCepRequest;
import project.rest.spring.model.User.Usuario;
import project.rest.spring.model.ViaCep.ViaCep;
import project.rest.spring.repository.Usuario.UsuarioRepository;

import java.util.List;

@Service
public class UserService {

    private final UsuarioRepository usuarioRepository;
    private final ViaCepRequest viaCepRequest;



    public UserService(UsuarioRepository usuarioRepository, ViaCepRequest viaCepRequest) {
        this.usuarioRepository = usuarioRepository;
        this.viaCepRequest = viaCepRequest;
    }

    public List<Usuario> listAll() {
        System.out.println("Service");
        return usuarioRepository.findAll();
    }

    public Usuario findByName(String name) {
        return usuarioRepository.findAll()
                .stream()
                .filter(user -> user.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not Found"));
    }

    public Usuario save(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public Usuario findByCpf(String cpf){
        return usuarioRepository.findAll()
                .stream()
                .filter(user -> user.getCpf().equals(cpf))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "CPF not Found"));
    }

    public ResponseEntity<Object> update(Usuario usuario, String cpf){
        try {

            Usuario user = findByCpf(cpf);

            if (user.getCpf()!= null){

                usuarioRepository.update(
                        usuario.getName(),
                        usuario.getEmail(),
                        user.getCpf()
                );
                return ResponseEntity.ok("Atualizado Com Sucesso !!! ");
            }


        }catch (Exception e){
            e.printStackTrace();
//            return HttpStatus.BAD_REQUEST;
        }

        return null;

    }

    public void delete(String cpf){
        usuarioRepository.deleteUser(cpf);
    }

    public ResponseEntity<Object> teste ( String cep, String cpf){
        String url = "https://viacep.com.br/ws/"+cep+"/json/";
        Usuario usuario= new Usuario();


        ViaCep viaCep = viaCepRequest.requestAddress(url);

        //Atualizar no banco com os dados do via cep

        usuarioRepository.updateAddress(
                viaCep.getCep(),
                viaCep.getLogradouro(),
                viaCep.getComplemento(),
                viaCep.getBairro(),
                viaCep.getLocalidade(),
                viaCep.getUf(),
                cpf);

        return ResponseEntity.ok("Deu bom meuuu");

    }


}
