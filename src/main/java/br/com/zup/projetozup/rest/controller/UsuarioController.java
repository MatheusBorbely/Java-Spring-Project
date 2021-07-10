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


    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/")
    public ResponseEntity<ResponseUsuario> salvar(@RequestBody @Valid RequestUsuario requestUsuario) {
        return usuarioService.salvar(requestUsuario);
    }

    @GetMapping("endereco/{id}")
    public ResponseEntity<ResponseUsuario> buscar(@PathVariable @Valid UUID id){
        return usuarioService.buscar(id);
    }

}
