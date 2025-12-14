package com.example.cuenta_mov.domain.model;

import com.example.cuenta_mov.domain.enums.TipoMovimiento;
import com.example.cuenta_mov.util.exception.SaldoInsuficienteException;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class Movimiento {

    private Long id;
    private Long entidad;
    private TipoMovimiento tipoMovimiento;
    private BigDecimal valor;
    private BigDecimal saldo;
    private Long cuentaId;
    private LocalDateTime fechaMovimiento;
    private String claveUnica;

    public Movimiento(BigDecimal valor, BigDecimal saldo, TipoMovimiento tipo, Long entidad) {
        this.saldo = saldo;
        this.claveUnica = UUID.randomUUID().toString();
        this.valor = valor;
        this.tipoMovimiento = tipo;
        this.entidad = entidad;
        this.fechaMovimiento = LocalDateTime.now();
    }

    public Movimiento(BigDecimal valor, BigDecimal saldo, TipoMovimiento tipo, Long entidad, Long cuentaId) {
        this.saldo = saldo;
        this.claveUnica = UUID.randomUUID().toString();
        this.valor = valor;
        this.tipoMovimiento = tipo;
        this.entidad = entidad;
        this.fechaMovimiento = LocalDateTime.now();
        this.cuentaId = cuentaId;
    }

    public Movimiento(TipoMovimiento tipoMovimiento,
            BigDecimal valor,
            BigDecimal saldo,
            LocalDateTime fechaMovimiento,
            String claveUnica
    ) {
        this.tipoMovimiento = tipoMovimiento;
        this.valor = valor;
        this.saldo = saldo;
        this.fechaMovimiento = fechaMovimiento;
        this.claveUnica = claveUnica;
    }
}
