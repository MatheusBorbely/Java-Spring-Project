package br.com.zup.projetozup.rest.dto.request;

import br.com.zup.projetozup.domain.entity.Usuario;
import br.com.zup.projetozup.validation.ExistUserCpf;
import br.com.zup.projetozup.validation.ExistUserEmail;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class RequestUsuario {

    @Size(min = 2, max = 100, message = "{nome.tamanho}")
    @NotBlank (message = "{nome.vazio}")
    private String nome;
    @Size(min = 2, max = 100, message = "{email.tamanho}")
    @ExistUserEmail(message = "{email.cadastrado}")
    @NotBlank (message = "{email.vazio}")
    private String email;
    @NotBlank (message = "{cpf.vazio}")
    @ExistUserCpf(message = "{cpf.cadastrado}")
    @CPF (message = "{cpf.invalido}")
    private String cpf;
    @Past
    @NotNull (message = "{data.vazia}")
    private LocalDate dataNasc;

    public Usuario build(){
        return new Usuario(this.nome, this.email,
                this.cpf.replaceAll("\\p{Punct}", ""), this.dataNasc);

    }
    // Getters ...

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


}
