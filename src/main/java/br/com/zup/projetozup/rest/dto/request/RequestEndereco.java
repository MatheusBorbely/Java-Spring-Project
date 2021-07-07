package br.com.zup.projetozup.rest.dto.request;

import br.com.zup.projetozup.domain.entity.Usuario;
import br.com.zup.projetozup.validation.ExistCep;
import br.com.zup.projetozup.validation.ExistUser;
import br.com.zup.projetozup.validation.ExistUserAddress;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@ExistUserAddress
public class RequestEndereco {

    @NotNull(message = "{numero.vazio}")
    private Integer numero;
    @Size(min = 2, max = 100, message = "{complemento.tamanho}")
    @NotBlank (message = "{complemento.vazio}")
    private String complemento;
    @ExistCep
    @Size(min = 8, max = 9, message = "{cep.tamanho}")
    @NotBlank (message = "{cep.vazio}")
    private String cep;
    @NotNull(message = "{usuario.vazio}")
    @ExistUser
    private UUID usuarioId;

    //Getters ...

    public Integer getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getCep() {
        return cep;
    }

    public UUID getUsuarioId() {

        return usuarioId;
    }
}
