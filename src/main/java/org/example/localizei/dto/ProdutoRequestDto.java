package org.example.localizei.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ProdutoRequestDto(
        @NotNull
        UUID usuarioId,

        @NotBlank(message = "Nome é obrigatório!")
        String nome,

        @NotBlank
        String codigoDeRastreio){}
