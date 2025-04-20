package org.example.localizei.dto;

import java.util.UUID;

public record ProdutoResponseDto(
        Long produtoId,
        UUID usuarioId,
        String nomeDoProduto,
        String codigoDeRastreio){}
