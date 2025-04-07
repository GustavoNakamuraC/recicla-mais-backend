package com.example.recicla_mais.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Resposta {
    private Long id;
    private Usuario usuario;
    private Publicacao publicacao;
    private String conteudo;
}