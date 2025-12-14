package com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.mapper;

import com.example.cuenta_mov.application.command.cuenta.CuentaCreateCommand;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.CreateCuentaRequest;

public class CuentaRequestMapper {

    public static CuentaCreateCommand toCommand(CreateCuentaRequest cuenta) {
        return new CuentaCreateCommand(cuenta.clienteId(),
                cuenta.tipoCuenta(),
                cuenta.entidad(),
                cuenta.saldoInicial());
    }
}
