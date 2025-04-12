package com.example.recicla_mais.service.mapper;

import com.example.recicla_mais.domain.Usuario;
import com.example.recicla_mais.repository.entity.UsuarioEntity;

public class UsuarioMapper {

    public static Usuario paraDomain(UsuarioEntity entity) {
        return Usuario.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .email(entity.getEmail())
                .pontos(entity.getPontos())
                .senha(entity.getSenha())
                .build();
    }

    public static UsuarioEntity paraEntity(Usuario domain) {
        return UsuarioEntity.builder()
                .id(domain.getId())
                .nome(domain.getNome())
                .email(domain.getEmail())
                .pontos(domain.getPontos())
                .senha(domain.getSenha())
                .build();
    }
}
