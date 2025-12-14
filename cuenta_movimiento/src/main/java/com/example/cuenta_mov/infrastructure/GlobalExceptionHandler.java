package com.example.cuenta_mov.infrastructure;

import com.example.cuenta_mov.util.GeneralResponse;
import com.example.cuenta_mov.util.exception.NotFoundException;
import com.example.cuenta_mov.util.exception.SaldoInsuficienteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<GeneralResponse<?>> handleNotFound(NotFoundException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(GeneralResponse.error(ex.getMessage(), null));
    }

    @ExceptionHandler(SaldoInsuficienteException.class)
    public ResponseEntity<GeneralResponse<?>> handleSaldoInsuficiente(SaldoInsuficienteException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(GeneralResponse.error(ex.getMessage(), null));
    }
}
