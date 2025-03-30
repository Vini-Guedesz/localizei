package org.example.localizei.dto;

import jakarta.validation.constraints.NotBlank;

public record ProdutoResponseCriacaoDto(
        @NotBlank(message = "Nome é obrigatório!")
        String name,

        @NotBlank(message = "Código de rastreio é obrigatório!")
        String CodigoDeRastreiro){}
