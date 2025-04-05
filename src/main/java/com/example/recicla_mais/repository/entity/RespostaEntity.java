package com.example.recicla_mais.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Resposta")
@Table(name = "respostas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RespostaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UsuarioEntity usuario;

    @ManyToOne
    private PublicacaoEntity publicacao;

    private String conteudo;

    private Integer curtidas;
}
