package br.com.zup.projetozup.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Endereco {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private UUID id;

    private String logradouro;

    private Integer numero;

    @Column(length = 100)
    private String complemento;

    private String bairro;

    private String cidade;

    private String estado;

    @Column(length = 8)
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @Deprecated
    public Endereco() {
    }

    public Endereco(String logradouro, Integer numero,
                    String complemento, String bairro, String cidade,
                    String estado, String cep, Usuario usuario) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.cep = cep;
        this.usuario = usuario;
    }
    //Getters

    public UUID getId() {
        return id;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getCep() {
        return cep;
    }

    public Usuario getUsuario() {
        return usuario;
    }
}
