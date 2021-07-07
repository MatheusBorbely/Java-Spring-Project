package br.com.zup.projetozup.microservice;

import br.com.zup.projetozup.domain.entity.Endereco;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url="https://viacep.com.br/ws/", name = "viacep")
public interface ViaCEPCliente {

    @GetMapping("{cep}/json")
    EnderecoDtoViaCep buscaEnderecoPor(@PathVariable("cep") String cep);
}
