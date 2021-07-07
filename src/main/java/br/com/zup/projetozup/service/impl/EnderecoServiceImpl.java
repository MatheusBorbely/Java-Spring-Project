package br.com.zup.projetozup.service.impl;

import br.com.zup.projetozup.domain.entity.Endereco;
import br.com.zup.projetozup.domain.repository.EnderecoRepository;
import br.com.zup.projetozup.domain.repository.UsuarioRepository;
import br.com.zup.projetozup.microservice.EnderecoDtoViaCep;
import br.com.zup.projetozup.microservice.ViaCEPCliente;
import br.com.zup.projetozup.rest.dto.request.RequestEndereco;
import br.com.zup.projetozup.rest.dto.response.ResponseEndereco;
import br.com.zup.projetozup.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class EnderecoServiceImpl  implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCEPCliente viaCEPCliente;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<ResponseEndereco> salvar(RequestEndereco requestEndereco) {

        EnderecoDtoViaCep enderecoDtoViaCep = viaCEPCliente.buscaEnderecoPor(requestEndereco.getCep());

        Endereco endereco = enderecoDtoViaCep.build(requestEndereco, usuarioRepository);

        enderecoRepository.save(endereco);

        URI location = ServletUriComponentsBuilder
                .newInstance()
                .path("http://localhost:8080/endereco/buscar/{id}")
                .buildAndExpand(endereco.getId())
                .toUri();


        ResponseEndereco responseEndereco = new ResponseEndereco(endereco);

        return ResponseEntity.created(location).body(responseEndereco);
    }

}
