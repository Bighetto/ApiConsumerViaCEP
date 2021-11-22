package project.rest.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import project.rest.spring.model.ViaCep;

public interface ViaCepRepository extends JpaRepository<ViaCep, Integer> {

}
