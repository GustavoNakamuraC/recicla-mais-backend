package com.example.recicla_mais.controller;

import com.example.recicla_mais.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;

    @PostMapping
    public ResponseEntity<LoginDto> logar(@RequestBody LoginDto loginDto){
        LoginDto login = service.validarCredenciais(loginDto);

        return ResponseEntity.ok(login);
    }
}
