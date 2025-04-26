package com.example.recicla_mais.controller;

import com.example.recicla_mais.domain.Publicacao;
import com.example.recicla_mais.service.PublicacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/publicacoes")
@RequiredArgsConstructor
public class PublicacaoController {

    private final PublicacaoService service;

    @PostMapping
    public ResponseEntity<Publicacao> criar(@RequestBody Publicacao novaPublicacao) {
        Publicacao resultado = service.criar(novaPublicacao);
        return ResponseEntity.created(
                UriComponentsBuilder
                        .newInstance()
                        .path("/publicacoes/{id}")
                        .buildAndExpand(novaPublicacao.getId())
                        .toUri()
        ).body(resultado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id) {
        service.apagar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Publicacao>> listar() {
        List<Publicacao> resposta = service.listar();
        return ResponseEntity.ok(resposta);
    }

    @PostMapping("/curtir/{id}")
    public ResponseEntity<Publicacao> curtir(@PathVariable Long id) {
        Publicacao resposta = service.curtir(id);
        return ResponseEntity.ok(resposta);
    }
}
