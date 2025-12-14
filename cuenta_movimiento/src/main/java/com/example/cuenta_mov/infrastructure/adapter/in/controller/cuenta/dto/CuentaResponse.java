package com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;
import com.example.cuenta_mov.domain.enums.TipoCuenta;

import java.math.BigDecimal;

public record CuentaResponse(Long id,
                             TipoCuenta tipoCuenta,
                             BigDecimal saldo,
                             Long clienteId,
                             Long entidad,
                             EstadoCuentaEnum estado,
                             String numeroCuenta,
                             String claveUnica) {

}
