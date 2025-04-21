package org.example.localizei.dto;

import jakarta.validation.constraints.Email;

public record UsuarioUpdateRequestDto(
        String nome,
        @Email(message = "O endereço de E-mail inserido não é válido!")
        String email
) {}
