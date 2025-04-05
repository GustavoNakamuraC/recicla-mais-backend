package com.example.recicla_mais.repository.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Publicacao")
@Table(name = "publicacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PublicacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UsuarioEntity usuario;

    private Integer curtidas;

    private String conteudo;

}
