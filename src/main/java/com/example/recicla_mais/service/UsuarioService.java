package com.example.recicla_mais.service;

import com.example.recicla_mais.domain.Usuario;
import com.example.recicla_mais.repository.UsuarioRepository;
import com.example.recicla_mais.repository.entity.UsuarioEntity;
import com.example.recicla_mais.service.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository repository;

    public Usuario cadastrar(Usuario usuario){
        return UsuarioMapper.paraDomain(
                repository.save(UsuarioMapper.paraEntity(usuario)));
    }

    public Usuario consultarPorId(Long id){
        Optional<UsuarioEntity> usuarioConsultado = repository.findById(id);

        if (usuarioConsultado.isEmpty()){
            throw new RuntimeException("Usuário não encontrado");
        }

        return UsuarioMapper.paraDomain(usuarioConsultado.get());
    }

    public Usuario consultarPorEmail(String email){
        Optional<UsuarioEntity> usuarioConsultado = repository.findByEmail(email);

        if (usuarioConsultado.isEmpty()){
            throw new RuntimeException("Usuário não encontrado");
        }

        return UsuarioMapper.paraDomain(usuarioConsultado.get());
    }

    public Usuario alterarPontuacao(Long id, Usuario novosPontos) {
        Usuario usuario = consultarPorId(id);

        usuario.adicionarPontos(novosPontos);

        return UsuarioMapper.paraDomain(
                repository.save(UsuarioMapper.paraEntity(usuario)));
    }

    public List<Usuario> listar() {
        return repository.findAll().stream()
                .map(UsuarioMapper::paraDomain).toList();
    }

}
