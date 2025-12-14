package com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.mapper;

import com.example.cuenta_mov.application.command.movimiento.MovimientoCommand;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto.MovimientoRequest;

public class MovimientoRequestMapper {

    public static MovimientoCommand toCommand(
            MovimientoRequest request
    ) {
        return new MovimientoCommand(
                request.cuentaId(),
                request.tipoMovimiento(),
                request.valor(),
                request.entidad()
        );
    }
}
