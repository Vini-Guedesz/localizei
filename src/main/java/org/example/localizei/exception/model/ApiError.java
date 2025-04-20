package org.example.localizei.exception.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ApiError {
    private int status;                         // Código HTTP (ex: 400, 409)
    private String error;                       // Tipo do erro (ex: "Bad Request")
    private String message;                     // Mensagem descritiva
    private String path;                        // Endpoint acessado (ex: "/api/usuarios")

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime timestamp;            // Data/hora do erro

    public ApiError(int status, String error, String message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
        this.timestamp = LocalDateTime.now();
    }
}