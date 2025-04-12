package com.example.recicla_mais.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Publicacao {
    private Long id;
    private Usuario usuario;
    private Integer curtidas;
    private String conteudo;
}