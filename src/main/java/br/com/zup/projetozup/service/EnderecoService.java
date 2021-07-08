package br.com.zup.projetozup.service;

import br.com.zup.projetozup.rest.dto.request.RequestEndereco;
import br.com.zup.projetozup.rest.dto.response.ResponseEndereco;
import org.springframework.http.ResponseEntity;


public interface EnderecoService {

    ResponseEntity<ResponseEndereco> salvar(RequestEndereco requestEndereco);

}
