package com.example.recicla_mais.service.mapper;

import com.example.recicla_mais.domain.Publicacao;
import com.example.recicla_mais.repository.entity.PublicacaoEntity;

public class PublicacaoMapper {

    public static Publicacao paraDomain(PublicacaoEntity entity) {
        return Publicacao.builder()
                .id(entity.getId())
                .usuario(UsuarioMapper.paraDomain(entity.getUsuario()))
                .curtidas(entity.getCurtidas())
                .conteudo(entity.getConteudo())
                .build();
    }

    public static PublicacaoEntity paraEntity(Publicacao domain) {
        return PublicacaoEntity.builder()
                .id(domain.getId())
                .usuario(UsuarioMapper.paraEntity(domain.getUsuario()))
                .curtidas(domain.getCurtidas())
                .conteudo(domain.getConteudo())
                .build();
    }

}
