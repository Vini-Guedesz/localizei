package org.example.localizei.service;

import org.example.localizei.dto.UsuarioRequestDto;
import org.example.localizei.dto.UsuarioResponseDto;
import org.example.localizei.dto.UsuarioUpdateRequestDto;
import org.example.localizei.entities.UsuarioEntity;
import org.example.localizei.exception.custom.RecursoNaoEncontradoException;
import org.example.localizei.mapper.UsuarioMapper;
import org.example.localizei.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

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

    public UsuarioResponseDto obterUsuarioPorId(UUID usuarioId) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findById(usuarioId);

        if (usuarioOpt.isPresent()) {
            return usuarioMapper.toResponse(usuarioOpt.get());
        } else {
            throw new RecursoNaoEncontradoException("Usuario não encontrado por id: " + usuarioId);
        }
    }

    public UsuarioResponseDto obterUsuarioPorEmail(String email) {
        Optional<UsuarioEntity> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            return usuarioMapper.toResponse(usuarioOpt.get());
        } else {
            throw new RecursoNaoEncontradoException("Usuario não encontrado por email: " + email);
        }
    }

    @Transactional
    public UsuarioResponseDto atualizarUsuario(UUID id, UsuarioUpdateRequestDto usuarioUpdateRequestDto) {
        UsuarioEntity usuarioParaSerAtualizado = usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado por id: " + id));

        if (usuarioUpdateRequestDto.nome() != null && !usuarioUpdateRequestDto.nome().isBlank()) {
            usuarioParaSerAtualizado.setNome(usuarioUpdateRequestDto.nome());
        }

        if (usuarioUpdateRequestDto.email() != null && !usuarioUpdateRequestDto.email().isBlank()) {
            usuarioParaSerAtualizado.setEmail(usuarioUpdateRequestDto.email());
        }

        UsuarioEntity usuarioAtualizado = usuarioRepository.save(usuarioParaSerAtualizado);
        return usuarioMapper.toResponse(usuarioAtualizado);
    }


}