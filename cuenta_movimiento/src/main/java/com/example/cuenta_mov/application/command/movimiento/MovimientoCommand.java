package com.example.cuenta_mov.application.command.movimiento;

import com.example.cuenta_mov.domain.enums.TipoMovimiento;

import java.math.BigDecimal;

public record MovimientoCommand(
        Long cuentaId,
        TipoMovimiento tipoMovimiento,
        BigDecimal valor,
        Long entidad
) {}
