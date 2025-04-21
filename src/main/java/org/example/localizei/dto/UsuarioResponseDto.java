package org.example.localizei.dto;


import org.example.localizei.entities.ProdutoEntity;

import java.util.Set;
import java.util.UUID;

public record UsuarioResponseDto(
        UUID id,
        String nome,
        String email,
        Set<ProdutoEntity> produtos) {}
