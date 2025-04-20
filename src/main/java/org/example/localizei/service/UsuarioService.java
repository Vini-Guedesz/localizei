package org.example.localizei.service;

import org.example.localizei.dto.UsuarioRequestDto;
import org.example.localizei.dto.UsuarioResponseDto;
import org.example.localizei.entities.UsuarioEntity;
import org.example.localizei.mapper.UsuarioMapper;
import org.example.localizei.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;


    @Transactional
    public UsuarioResponseDto criarUsuario(UsuarioRequestDto usuarioRequestDto) {

        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuarioRequestDto);
        UsuarioEntity usuarioSalvo = usuarioRepository.save(usuarioEntity);
        return usuarioMapper.toResponse(usuarioSalvo);

    }
}