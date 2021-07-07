package br.com.zup.projetozup.rest.dto.response;

import br.com.zup.projetozup.domain.entity.Endereco;
import br.com.zup.projetozup.domain.entity.Usuario;

import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

public class ResponseUsuario {

    private UUID id;
    private String nome;
    private String email;
    private String cpf;
    private LocalDate dataNasc;
    private Set<Endereco> enderecos;

    public ResponseUsuario(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCpf();
        this.dataNasc = usuario.getDataNasc();
        this.enderecos = usuario.getEnderecos();
    }
    // Getters ...
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
