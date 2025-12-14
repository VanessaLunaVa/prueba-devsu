package com.example.cuenta_mov.domain.enums;

import com.example.cuenta_mov.util.exception.MontoInvalidoException;
import com.example.cuenta_mov.util.exception.SaldoInsuficienteException;

import java.math.BigDecimal;

public enum TipoMovimiento {

    SUMA {
        @Override
        public BigDecimal aplicar(BigDecimal saldo, BigDecimal monto) {
            return saldo.add(monto);
        }
    },
    RESTA {
        @Override
        public BigDecimal aplicar(BigDecimal saldo, BigDecimal monto) {
            return saldo.subtract(monto);
        }
    };

    public abstract BigDecimal aplicar(BigDecimal saldo, BigDecimal monto);

    public void validar(BigDecimal monto, BigDecimal saldoActual) {
        if (monto.compareTo(BigDecimal.ZERO) <= 0) {
            throw new MontoInvalidoException();
        }
        if (this == RESTA && saldoActual.compareTo(monto) < 0) {
            throw new SaldoInsuficienteException();
        }
    }
}
