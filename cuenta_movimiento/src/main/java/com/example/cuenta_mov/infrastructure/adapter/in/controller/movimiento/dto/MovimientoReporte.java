package com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto;

import com.example.cuenta_mov.domain.enums.TipoMovimiento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovimientoReporte(TipoMovimiento tipoMovimiento,
                                LocalDateTime fecha, BigDecimal valor,
                                BigDecimal saldo, String claveUnica) {
}
