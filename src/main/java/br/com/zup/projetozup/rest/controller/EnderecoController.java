package br.com.zup.projetozup.rest.controller;

import br.com.zup.projetozup.rest.dto.request.RequestEndereco;
import br.com.zup.projetozup.rest.dto.response.ResponseEndereco;
import br.com.zup.projetozup.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ResponseEndereco> salvar(@RequestBody @Valid RequestEndereco requestEndereco) {
        return enderecoService.salvar(requestEndereco);
    }

}
