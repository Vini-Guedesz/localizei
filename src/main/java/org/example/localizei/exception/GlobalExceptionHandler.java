package org.example.localizei.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        String campo = ex.getBindingResult().getFieldError().getField();
        String mensagem = ex.getBindingResult().getFieldError().getDefaultMessage();

        ApiErrorResponse erro = new ApiErrorResponse();
        erro.mensagem = mensagem;
        erro.campo = campo;
        erro.dataHora = LocalDateTime.now().toString();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
    }
}