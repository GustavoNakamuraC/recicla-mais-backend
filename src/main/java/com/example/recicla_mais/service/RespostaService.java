package com.example.recicla_mais.service;

import com.example.recicla_mais.domain.Resposta;
import com.example.recicla_mais.domain.Usuario;
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

    public Resposta criar(Resposta resposta){
        Usuario usuario = usuarioService.consultarPorId(resposta.getUsuario().getId());

        usuarioService.alterarPontuacao(usuario, 5);

        resposta.setUsuario(usuario);
        resposta.setPublicacao(publicacaoService.consultarPorId(resposta.getPublicacao().getId()));

        return RespostaMapper.paraDomain(repository.save(RespostaMapper.paraEntity(resposta)));
    }

    public List<Resposta> listarPorPublicacao(Long id){
        return repository.findAllByPublicacaoId(id)
                .stream().map(RespostaMapper::paraDomain).toList();
    }
}
