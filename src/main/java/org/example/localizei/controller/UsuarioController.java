package org.example.localizei.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.localizei.dto.UsuarioRequestDto;
import org.example.localizei.dto.UsuarioResponseDto;
import org.example.localizei.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller("/api/usuario")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Operation(description = "Cria um usuário.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Retorna o usuário que foi criado."),
            @ApiResponse(responseCode = "400", description = "O endereço de E-mail inserido não é válido!")
    })
    @PostMapping("/criar")
    public ResponseEntity<UsuarioResponseDto> criar(@Valid @RequestBody UsuarioRequestDto usuarioRequestDto) {
        UsuarioResponseDto usuarioResponseDto = usuarioService.criarUsuario(usuarioRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponseDto);
    }

}
