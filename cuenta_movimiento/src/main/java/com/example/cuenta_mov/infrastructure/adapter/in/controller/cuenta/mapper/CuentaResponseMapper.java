package com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.mapper;

import com.example.cuenta_mov.domain.model.Cuenta;
import com.example.cuenta_mov.domain.model.EstadoCuenta;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.CuentaResponse;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.EstadoCuentaResponse;

public class CuentaResponseMapper {


    public static CuentaResponse toResponse(Cuenta cuentaToSave) {
        return new CuentaResponse(cuentaToSave.getId(), cuentaToSave.getTipoCuenta(),
                cuentaToSave.getSaldo(), cuentaToSave.getClienteId(),
                cuentaToSave.getEntidad(), cuentaToSave.getEstado(),
                cuentaToSave.getNumeroCuenta(), cuentaToSave.getNumeroCuenta());
    }

    public static EstadoCuentaResponse toResponseEstadoCuenta(EstadoCuenta m) {
        return new EstadoCuentaResponse(m.getEntidad(),
                m.getNumeroCuenta(), m.getTipoCuenta(), m.getSaldo(), m.getEstado());
    }
}
