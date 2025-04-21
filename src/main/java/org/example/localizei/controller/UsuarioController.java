package org.example.localizei.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.localizei.dto.UsuarioRequestDto;
import org.example.localizei.dto.UsuarioResponseDto;
import org.example.localizei.dto.UsuarioUpdateRequestDto;
import org.example.localizei.exception.model.ApiError;
import org.example.localizei.service.UsuarioService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@Controller("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(summary = "Cria um novo usuário")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Usuário criado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro de validação dos dados enviados",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Conflito: e-mail já cadastrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    @PostMapping("/criar")
    public ResponseEntity<UsuarioResponseDto> criar(
            @Valid @RequestBody UsuarioRequestDto usuarioRequestDto
    ) {
        UsuarioResponseDto usuarioResponseDto = usuarioService.criarUsuario(usuarioRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponseDto);
    }


    @Operation(summary = "Busca o usuario por Email")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário encontrado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro de validação dos dados enviados",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    @GetMapping("/buscar-por-email")
    public ResponseEntity<UsuarioResponseDto> buscarPorEmail(@RequestParam String email) {
        UsuarioResponseDto usuarioResponseDto = usuarioService.obterUsuarioPorEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponseDto);
    }

    @Operation(summary = "Busca o usuario por ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário encontrado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro de validação dos dados enviados",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    @GetMapping("/buscar-por-id")
    public ResponseEntity<UsuarioResponseDto> buscarPorId(@RequestParam UUID id) {
        UsuarioResponseDto usuarioResponseDto = usuarioService.obterUsuarioPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponseDto);
    }

    @Operation(summary = "Atualiza um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário atualizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro de validação dos dados enviados",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "409",
                    description = "Conflito: e-mail já cadastrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    @PatchMapping("/atualizar-usuario/{id}")
    public ResponseEntity<UsuarioResponseDto> atualizarUsuario(
            @PathVariable UUID id,
            @Valid @RequestBody UsuarioUpdateRequestDto usuarioUpdateRequestDto
    ) {
        UsuarioResponseDto usuarioResponseDto = usuarioService.atualizarUsuario(id, usuarioUpdateRequestDto);
        return ResponseEntity.ok(usuarioResponseDto);
    }

    @Operation(summary = "Lista usuarios por pagina")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Pagina com usuarios retornada",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    @GetMapping("/listar-todos-usuarios")
    public ResponseEntity<Page<UsuarioResponseDto>> listarUsuarios(Pageable pageable) {
        Page<UsuarioResponseDto> usuarios = usuarioService.listarUsuarios(pageable);
        return ResponseEntity.ok(usuarios);
    }

    @Operation(summary = "Deleta um usuário existente")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário deletado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = UsuarioResponseDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro de validação dos dados enviados",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = ApiError.class)
                    )
            )
    })
    @DeleteMapping("/deletar-usuario")
    public ResponseEntity<UsuarioResponseDto> deletarUsuario(@RequestParam UUID id) {
        UsuarioResponseDto usuarioResponseDto = usuarioService.deletarUsuario(id);
        return ResponseEntity.ok(usuarioResponseDto);
    }

}
