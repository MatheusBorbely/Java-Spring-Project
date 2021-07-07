package br.com.zup.projetozup.domain.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usuario_id")
    private UUID id;

    @Column(length = 100)
    private String nome;

    @Column(length = 100, unique = true)
    private String email;


    @Column(length = 11, unique = true)
    private String cpf;

    private LocalDate dataNasc;

    @OneToMany(mappedBy = "usuario")
    private Set<Endereco> enderecos;

    @Deprecated
    public Usuario() {
    }

    public Usuario( String nome, String email,
                   String cpf, LocalDate dataNasc) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.dataNasc = dataNasc;
    }

     //Getters ...

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public Set<Endereco> getEnderecos() {
        return enderecos;
    }
}
