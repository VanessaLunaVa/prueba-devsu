package com.example.cuenta_mov.application.command.cuenta;

import com.example.cuenta_mov.domain.enums.TipoCuenta;

import java.math.BigDecimal;

public record CuentaCreateCommand(Long clienteId,
                                  TipoCuenta tipoCuenta,
                                  Long entidad,
                                  BigDecimal saldoInicial) {
}
