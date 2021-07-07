package br.com.zup.projetozup.microservice;

import br.com.zup.projetozup.domain.entity.Endereco;
import br.com.zup.projetozup.domain.entity.Usuario;
import br.com.zup.projetozup.domain.repository.EnderecoRepository;
import br.com.zup.projetozup.domain.repository.UsuarioRepository;
import br.com.zup.projetozup.rest.dto.request.RequestEndereco;

import java.util.Optional;

public class EnderecoDtoViaCep {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String erro;



    public Endereco build(RequestEndereco requestEndereco, UsuarioRepository usuarioRepository){

        Optional<Usuario> usuario = usuarioRepository.findById(requestEndereco.getUsuarioId());

       return new Endereco(this.logradouro,
                requestEndereco.getNumero(),
                requestEndereco.getComplemento(),
                this.bairro,
                this.localidade,
                this.uf,
                requestEndereco.getCep().replaceAll("\\p{Punct}", ""),
                usuario.get());

    }
    //Getters ...

    public String getErro() {
        return erro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

}

/*
    {
            "cep": "01001-000",
            "logradouro": "Praça da Sé",
            "complemento": "lado ímpar",
            "bairro": "Sé",
            "localidade": "São Paulo",
            "uf": "SP",
            "ibge": "3550308",
            "gia": "1004",
            "ddd": "11",
            "siafi": "7107"
            }*/
