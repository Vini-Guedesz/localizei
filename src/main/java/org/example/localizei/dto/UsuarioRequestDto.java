package org.example.localizei.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioRequestDto(
        @NotBlank(message = "Nome é obrigatório!")
        String nome,

        @NotBlank(message = "Iserir o E-mail é obrigatório!")
        @Email(message = "O endereço de E-mail inserido não é válido!")
        String email) {}
