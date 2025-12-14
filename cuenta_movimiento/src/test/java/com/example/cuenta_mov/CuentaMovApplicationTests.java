package com.example.cuenta_mov;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;
import com.example.cuenta_mov.domain.enums.TipoCuenta;
import com.example.cuenta_mov.domain.model.Cuenta;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CuentaMovApplicationTests {

    @Test
    void crearCuentaPendiente() {
        Cuenta cuenta = Cuenta.create(30L, 1041L,
                TipoCuenta.AHORRO, new BigDecimal(120000));

        assertEquals(EstadoCuentaEnum.PENDIENTE_ACTIVACION, cuenta.getEstado());
    }



}
