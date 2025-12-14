package com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto;


import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimientoResponse(Long id, LocalDateTime fecha, BigDecimal valor,
                                 BigDecimal saldo, String claveUnica, Long cuentaId) {}


