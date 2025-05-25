package com.example.recicla_mais.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class LoginDto {
    private String email;
    private String senha;
}
