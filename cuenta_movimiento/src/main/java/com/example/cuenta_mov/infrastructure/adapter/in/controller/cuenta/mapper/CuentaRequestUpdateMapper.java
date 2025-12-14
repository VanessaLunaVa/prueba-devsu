package com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.mapper;

import com.example.cuenta_mov.application.command.cuenta.CuentaUpdateCommand;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto.UpdateCuentaRequest;

public class CuentaRequestUpdateMapper {

    public static CuentaUpdateCommand toCommand(UpdateCuentaRequest cuenta) {
        return new CuentaUpdateCommand(cuenta.estado(), cuenta.entidad());
    }
}
