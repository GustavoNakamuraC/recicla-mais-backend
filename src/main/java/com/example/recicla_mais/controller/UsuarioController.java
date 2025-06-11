package com.example.recicla_mais.controller;

import com.example.recicla_mais.domain.Usuario;
import com.example.recicla_mais.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioService service;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        Usuario usuarioSalvo = service.cadastrar(usuario);

        return ResponseEntity
                .created(
                        UriComponentsBuilder
                                .newInstance()
                                .path("/usuarios/{id}")
                                .buildAndExpand(usuarioSalvo.getId())
                                .toUri()
                )
                .body(usuarioSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultarPorId(@PathVariable Long id){
        Usuario usuarioConsultado = service.consultarPorId(id);

        return ResponseEntity.ok(usuarioConsultado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Usuario>> listar(){
        List<Usuario> usuarios = service.listar();

        return ResponseEntity.ok(usuarios);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> alterarPontuacao(@PathVariable Long id, @RequestBody Usuario novosPontos){
        Usuario usuarioNovo = service.alterarPontuacao(id, novosPontos);

        return ResponseEntity.ok(usuarioNovo);
    }
}

