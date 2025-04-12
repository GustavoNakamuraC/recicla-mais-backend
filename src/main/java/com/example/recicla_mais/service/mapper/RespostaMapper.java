package com.example.recicla_mais.service.mapper;

import com.example.recicla_mais.domain.Resposta;
import com.example.recicla_mais.repository.entity.RespostaEntity;

public class RespostaMapper {

    public Resposta paraDomain(RespostaEntity entity) {
        return Resposta.builder()
                .id(entity.getId())
                .usuario(UsuarioMapper.paraDomain(entity.getUsuario()))
                .publicacao(PublicacaoMapper.paraDomain(entity.getPublicacao()))
                .conteudo(entity.getConteudo())
                .build();
    }

    public RespostaEntity paraEntity(Resposta domain) {
        return RespostaEntity.builder()
                .id(domain.getId())
                .usuario(UsuarioMapper.paraEntity(domain.getUsuario()))
                .publicacao(PublicacaoMapper.paraEntity(domain.getPublicacao()))
                .conteudo(domain.getConteudo())
                .build();
    }
}
