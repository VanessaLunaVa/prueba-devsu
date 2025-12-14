package com.example.cuenta_mov.domain.model;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;
import com.example.cuenta_mov.domain.enums.TipoCuenta;
import com.example.cuenta_mov.domain.enums.TipoMovimiento;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Getter
@Setter
public class Cuenta {
    private Long id;
    private Long entidad;
    private String numeroCuenta;
    private TipoCuenta tipoCuenta;
    private BigDecimal saldo;
    private EstadoCuentaEnum estado;
    private String claveUnica;
    private Long clienteId;
    private final List<Movimiento> movimientos = new ArrayList<>();

    public Cuenta(Long entidad, String numeroCuenta, TipoCuenta tipoCuenta,
                  BigDecimal saldoInicial, EstadoCuentaEnum estado, String claveUnica, Long clienteId) {
        this.entidad = entidad;
        this.numeroCuenta = numeroCuenta;
        this.tipoCuenta = tipoCuenta;
        this.saldo = saldoInicial;
        this.estado = estado;
        this.claveUnica = claveUnica;
        this.clienteId = clienteId;
    }

    public static Cuenta create(Long clienteId, Long entidad,
            TipoCuenta tipoCuenta, BigDecimal saldoInicial
    ) {
        if (entidad == null) {
            throw new IllegalArgumentException("La entidad es obligatoria");
        }

        if (saldoInicial.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Debe crear la cuenta con un saldo inicial");
        }

        String claveUnica = UUID.randomUUID().toString();
        String numeroCuenta = UUID.randomUUID().toString();

        return new Cuenta(entidad, numeroCuenta, tipoCuenta, saldoInicial, EstadoCuentaEnum.PENDIENTE_ACTIVACION,
                claveUnica, clienteId);
    }

    public Movimiento registrarMovimiento(
            BigDecimal valor,
            TipoMovimiento tipo,
            Long entidad
    ) {
        tipo.validar(valor, saldo);
        Movimiento movimiento = new Movimiento(valor, saldo, tipo, entidad, id);
        saldo = tipo.aplicar(saldo, valor);
        movimientos.add(movimiento);

        return movimiento;
    }

    public void cancelarCuentas() {
        estado = EstadoCuentaEnum.CANCELADA;
    }
}
