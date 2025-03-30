package org.example.localizei.mapper;

import org.example.localizei.dto.UsuarioRequestDto;
import org.example.localizei.dto.UsuarioResponseDto;
import org.example.localizei.entities.UsuarioEntity;
import org.mapstruct.*;

@Mapper(
        componentModel = "spring",
        uses = ProdutoMapper.class // Adicione esta linha para usar o ProdutoMapper
)
public interface UsuarioMapper {

    // Converter UsuarioRequestDto → UsuarioEntity
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "produtos", ignore = true)
    UsuarioEntity toEntity(UsuarioRequestDto dto);

    // Converter UsuarioEntity → UsuarioResponseDto
    @Mapping(source = "produtos", target = "produtos")
    UsuarioResponseDto toResponse(UsuarioEntity entity);
}