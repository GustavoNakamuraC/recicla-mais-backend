package com.example.recicla_mais.service;

import com.example.recicla_mais.domain.Publicacao;
import com.example.recicla_mais.domain.Usuario;
import com.example.recicla_mais.repository.PublicacaoRepository;
import com.example.recicla_mais.repository.entity.PublicacaoEntity;
import com.example.recicla_mais.service.mapper.PublicacaoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PublicacaoService {

    private final PublicacaoRepository repository;
    private final UsuarioService usuarioService;

    public Publicacao criar(Publicacao novaPublicacao) {
        Usuario usuario = usuarioService.consultarPorId(novaPublicacao.getUsuario().getId());
        novaPublicacao.setUsuario(usuario);
        return PublicacaoMapper.paraDomain(repository.save(PublicacaoMapper.paraEntity(novaPublicacao)));
    }

    public void apagar(Long id) {
        repository.deleteById(id);
    }

    public List<Publicacao> listar() {
        return repository.findAll().stream().map(PublicacaoMapper::paraDomain).toList();
    }

    public Publicacao curtir(Long id) {
        Publicacao publicacao = this.consultarPorId(id);
        publicacao.curtir();
        return PublicacaoMapper.paraDomain(repository.save(PublicacaoMapper.paraEntity(publicacao)));
    }

    public Publicacao consultarPorId(Long id) {
        Optional<PublicacaoEntity> publicacao = repository.findById(id);

        if(publicacao.isEmpty()) {
            throw new RuntimeException("Publicação não encontrada pelo id.");
        }

        return PublicacaoMapper.paraDomain(publicacao.get());
    }


}
