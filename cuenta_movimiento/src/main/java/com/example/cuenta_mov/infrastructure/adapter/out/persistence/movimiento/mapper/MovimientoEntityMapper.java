package com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.mapper;

import com.example.cuenta_mov.domain.model.Movimiento;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.entity.MovimientoEntity;
import org.springframework.stereotype.Component;

@Component
public class MovimientoEntityMapper {

    public Movimiento toDomain(MovimientoEntity entity) {
        Movimiento movimiento = new Movimiento(
                entity.getTipoMovimiento(),
                entity.getValor(),
                entity.getSaldo(),
                entity.getFecha(),
                entity.getClaveUnica()
        );
        movimiento.setId(entity.getId());
        return movimiento;
    }

    public MovimientoEntity toEntity(Movimiento movimiento) {
        MovimientoEntity entity = new MovimientoEntity();
        entity.setId(movimiento.getId());
        entity.setEntidad(movimiento.getEntidad());
        entity.setFecha(movimiento.getFechaMovimiento());
        entity.setTipoMovimiento(movimiento.getTipoMovimiento());
        entity.setValor(movimiento.getValor());
        entity.setSaldo(movimiento.getSaldo());
        entity.setCuentaId(movimiento.getCuentaId());
        entity.setClaveUnica(movimiento.getClaveUnica());
        return entity;
    }
}
