package com.example.recicla_mais.controller;

import com.example.recicla_mais.domain.Resposta;
import com.example.recicla_mais.repository.entity.RespostaEntity;
import com.example.recicla_mais.service.RespostaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/respostas")
@RequiredArgsConstructor
public class RespostaController {
    private RespostaService service;

    @PostMapping
    public ResponseEntity<Resposta> criar(@RequestBody Resposta resposta){
        Resposta respostaSalva = service.criar(resposta);

        return ResponseEntity.created(
                UriComponentsBuilder
                        .newInstance()
                        .path("/respostas/{id}")
                        .buildAndExpand(respostaSalva.getId())
                        .toUri()
        ).body(respostaSalva);
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<Resposta>> listarPorPublicacao(@PathVariable Long id){
        List<Resposta> respostas = service.listarPorPublicacao(id);

        return ResponseEntity.ok(respostas);
    }
}
