package com.example.recicla_mais.repository.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "Publicacao")
@Table(name = "publicacoes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PublicacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private UsuarioEntity usuario;

    private Integer curtidas;

    private String conteudo;

}
