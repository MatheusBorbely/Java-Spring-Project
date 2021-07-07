package br.com.zup.projetozup.service.impl;

import br.com.zup.projetozup.domain.entity.Usuario;
import br.com.zup.projetozup.domain.repository.UsuarioRepository;
import br.com.zup.projetozup.rest.dto.request.RequestUsuario;
import br.com.zup.projetozup.rest.dto.response.ResponseUsuario;
import br.com.zup.projetozup.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.net.URI;
import java.util.UUID;


@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public ResponseEntity<ResponseUsuario> salvar( RequestUsuario requestUsuario) {

        Usuario usuario = requestUsuario.build();

        usuarioRepository.save(usuario);

        URI location = ServletUriComponentsBuilder
                .newInstance()
                .path("http://localhost:8080/usuario/endereco/buscar/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();

        ResponseUsuario responseUsuario = new ResponseUsuario(usuario);

        return ResponseEntity.created(location).body(responseUsuario);
    }

    @Override
    public ResponseEntity<ResponseUsuario> buscar(UUID id) {
        return usuarioRepository.findUsuarioFetchEndereco(id)
                .map(usuario -> {
                    ResponseUsuario responseUsuario = new ResponseUsuario(usuario);
                   return ResponseEntity.ok().body(responseUsuario);
                })
                .orElse(ResponseEntity.notFound().build());
    }

}
