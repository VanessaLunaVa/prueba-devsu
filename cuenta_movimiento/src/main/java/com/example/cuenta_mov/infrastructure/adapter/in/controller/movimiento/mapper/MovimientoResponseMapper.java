package com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.mapper;

import com.example.cuenta_mov.domain.model.EstadoCuentaMovimientos;
import com.example.cuenta_mov.domain.model.Movimiento;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto.EstadoCuentaMovimientosResponse;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto.MovimientoReporte;
import com.example.cuenta_mov.infrastructure.adapter.in.controller.movimiento.dto.MovimientoResponse;

import java.util.List;

public class MovimientoResponseMapper {

    public static MovimientoResponse toResponse(Movimiento movimiento) {
        return new MovimientoResponse(movimiento.getId(), movimiento.getFechaMovimiento(), movimiento.getValor(),
                movimiento.getSaldo(), movimiento.getClaveUnica(), movimiento.getCuentaId());
    }

    public static EstadoCuentaMovimientosResponse toReporte(EstadoCuentaMovimientos estadoCuenta) {
        List<MovimientoReporte> lstMovimientos = estadoCuenta
                .getLstMovimientos().stream().map(m -> new MovimientoReporte(m.getTipoMovimiento(), m.getFechaMovimiento(), m.getValor(),
                        m.getSaldo(), m.getClaveUnica())).toList();
        return  new EstadoCuentaMovimientosResponse(estadoCuenta.getEntidad(), estadoCuenta.getNumeroCuenta(),
                estadoCuenta.getTipoCuenta(), estadoCuenta.getSaldo(), estadoCuenta.getEstado(), lstMovimientos);
    }
}
