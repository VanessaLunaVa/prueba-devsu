package com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto;

import com.example.cuenta_mov.domain.enums.TipoCuenta;

import java.math.BigDecimal;

public record CreateCuentaRequest(
    Long clienteId,
    Long entidad,
    BigDecimal saldoInicial,
    TipoCuenta tipoCuenta
){}
