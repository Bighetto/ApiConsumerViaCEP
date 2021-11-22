package project.rest.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "Nome")
    private String name;

    @Column(name = "CPF")
    private Integer cpf;

    @Column(name = "email")
    private String email;

    public Usuario(){
    }

    public Usuario(Integer id, String name, Integer cpf, String email) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cpf=" + cpf +
                ", email='" + email + '\'' +
                '}';
    }
}
