package com.example.recicla_mais.service;

import com.example.recicla_mais.controller.LoginDto;
import com.example.recicla_mais.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UsuarioService usuarioService;

    public LoginDto validarCredenciais(LoginDto loginDto){
        Usuario usuario = usuarioService.consultarPorEmail(loginDto.getEmail());

        if (!loginDto.getEmail().equals(usuario.getEmail()) || !loginDto.getSenha().equals(usuario.getSenha())){
            throw new RuntimeException("Email ou senha inválidos.");
        }

        loginDto.setUsuario(usuario);

        return loginDto;
    }
}
