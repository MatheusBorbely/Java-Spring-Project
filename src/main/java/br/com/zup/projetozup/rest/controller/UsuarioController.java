package br.com.zup.projetozup.rest.controller;

import br.com.zup.projetozup.rest.dto.request.RequestUsuario;
import br.com.zup.projetozup.rest.dto.response.ResponseUsuario;
import br.com.zup.projetozup.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<ResponseUsuario> salvar(@RequestBody @Valid RequestUsuario requestUsuario) {
        return usuarioService.salvar(requestUsuario);
    }

    @GetMapping("endereco/buscar/{id}")
    public ResponseEntity<ResponseUsuario> buscar(@PathVariable UUID id){
        return usuarioService.buscar(id);
    }

}
