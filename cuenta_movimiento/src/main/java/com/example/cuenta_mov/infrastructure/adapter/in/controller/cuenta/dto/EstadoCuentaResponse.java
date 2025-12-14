package com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;
import com.example.cuenta_mov.domain.enums.TipoCuenta;

import java.math.BigDecimal;

public record EstadoCuentaResponse(Long entidad,
        String numeroCuenta,
        TipoCuenta tipoCuenta,
        BigDecimal saldo,
        EstadoCuentaEnum estado) {
}
