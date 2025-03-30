package org.example.localizei.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(
        @NotBlank(message = "Nome é obrigatório!")
        String nome,

        @NotBlank(message = "Nome é obrigatório!")
        @Email(message = "E-mail inválido!")
        String email) {}
