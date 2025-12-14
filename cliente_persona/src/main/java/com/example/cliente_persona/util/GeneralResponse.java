package com.example.cliente_persona.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class GeneralResponse <T> {

    private final boolean success;
    private final String message;
    private final T data;
    private final Object errors;
    private final LocalDateTime timestamp;

    public static <T> GeneralResponse<T> ok(String message, T data) {
        return new GeneralResponse<>(true, message, data, null, LocalDateTime.now());
    }

    public static <T> GeneralResponse<T> error(String message, Object errors) {
        return new GeneralResponse<>(false, message, null, errors, LocalDateTime.now());
    }
}