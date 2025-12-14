package com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto;

import com.example.cuenta_mov.domain.enums.TipoMovimiento;

import java.math.BigDecimal;

public record MovimientoRequest(Long entidad, TipoMovimiento tipoMovimiento,
                                BigDecimal valor, Long cuentaId) {

}
