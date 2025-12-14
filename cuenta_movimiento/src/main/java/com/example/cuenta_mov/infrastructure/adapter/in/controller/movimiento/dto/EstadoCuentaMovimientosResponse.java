package com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;
import com.example.cuenta_mov.domain.enums.TipoCuenta;

import java.math.BigDecimal;
import java.util.List;

public record EstadoCuentaMovimientosResponse(Long entidad,
                                              String numeroCuenta,
                                              TipoCuenta tipoCuenta,
                                              BigDecimal saldo,
                                              EstadoCuentaEnum estado,
                                              List<MovimientoReporte> lstMovimientos) {
}
