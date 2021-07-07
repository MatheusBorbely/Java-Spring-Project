package br.com.zup.projetozup.service;

import br.com.zup.projetozup.rest.dto.request.RequestUsuario;
import br.com.zup.projetozup.rest.dto.response.ResponseUsuario;
import org.springframework.http.ResponseEntity;

import java.util.UUID;


public interface UsuarioService {

    ResponseEntity<ResponseUsuario> salvar(RequestUsuario requestUsuario);

    ResponseEntity<ResponseUsuario> buscar(UUID id);
}
