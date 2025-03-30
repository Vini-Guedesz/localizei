package org.example.localizei.dto;

import java.util.UUID;

public record ProdutoResponseDto(
        UUID produtoId,
        UUID usuarioId,
        String nomeDoProduto,
        String codigoDeRastreio){}
