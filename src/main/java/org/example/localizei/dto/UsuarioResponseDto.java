package org.example.localizei.dto;

import java.util.List;
import java.util.UUID;

public record UsuarioResponseDto(
        UUID id,
        String nome,
        String email,
        List <ProdutoResponseDto> produtos) {}
