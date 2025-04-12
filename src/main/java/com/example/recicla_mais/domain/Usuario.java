package com.example.recicla_mais.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
public class Usuario {
    private Long id;
    private String nome;
    private String email;
    private Integer pontos;
    private String senha;
}