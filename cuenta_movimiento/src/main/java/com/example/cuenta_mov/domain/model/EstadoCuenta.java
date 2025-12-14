package com.example.cuenta_mov.domain.model;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;
import com.example.cuenta_mov.domain.enums.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
public class EstadoCuenta {
    private Long entidad;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private BigDecimal saldo;
    private EstadoCuentaEnum estado;
}
