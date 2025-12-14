package com.example.cuenta_mov.domain.model;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;
import com.example.cuenta_mov.domain.enums.TipoCuenta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class EstadoCuentaMovimientos {
    private Long entidad;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private BigDecimal saldo;
    private EstadoCuentaEnum estado;
    private List<Movimiento> lstMovimientos;
}
