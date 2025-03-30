package org.example.localizei.mapper;

import org.example.localizei.dto.ProdutoRequestDto;
import org.example.localizei.dto.ProdutoResponseDto;
import org.example.localizei.entities.ProdutoEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    // Mapeia ProdutoEntity → ProdutoResponseDto
    @Mapping(source = "id", target = "produtoId")
    @Mapping(source = "nome", target = "nomeDoProduto")
    @Mapping(source = "usuario.id", target = "usuarioId")
    ProdutoResponseDto toResponse(ProdutoEntity produto);

    // Mapeia ProdutoRequestDto → ProdutoEntity
    @Mapping(target = "id", ignore = true) // ID é gerado pelo banco
    @Mapping(target = "usuario", ignore = true) // Usuário será definido manualmente
    ProdutoEntity toEntity(ProdutoRequestDto request);
}