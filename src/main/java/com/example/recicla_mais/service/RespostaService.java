package com.example.recicla_mais.service;

import com.example.recicla_mais.domain.Resposta;
import com.example.recicla_mais.repository.RespostaRepository;
import com.example.recicla_mais.service.mapper.RespostaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RespostaService {
    private final RespostaRepository repository;
    private final UsuarioService usuarioService;
    private final PublicacaoService publicacaoService;
    private final RespostaMapper mapper;

    public Resposta criar(Resposta resposta){
        resposta.setUsuario(usuarioService.consultarPorId(resposta.getUsuario().getId()));
        resposta.setPublicacao(publicacaoService.consultarPorId(resposta.getPublicacao().getId()));

        return mapper.paraDomain(repository.save(mapper.paraEntity(resposta)));
    }

    public List<Resposta> listarPorPublicacao(Long id){
        return repository.findAllByPublicacaoId(id)
                .stream().map(mapper::paraDomain).toList();
    }
}
