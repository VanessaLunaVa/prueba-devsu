package com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.mapper;

import com.example.cuenta_mov.domain.model.Cuenta;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.entity.CuentaEntity;
import org.springframework.stereotype.Component;

@Component
public class CuentaEntityMapper {

    public Cuenta toDomain(CuentaEntity e) {
        return new Cuenta(
                e.getId(),
                e.getEntidad(),
                e.getNumeroCuenta(),
                e.getTipoCuenta(),
                e.getSaldoInicial(),
                e.getEstado(),
                e.getClaveUnica(),
                e.getClienteId()
        );
    }

    public CuentaEntity toEntity(Cuenta d) {
        CuentaEntity e = new CuentaEntity();
        e.setId(d.getId());
        e.setEntidad(d.getEntidad());
        e.setNumeroCuenta(d.getNumeroCuenta());
        e.setTipoCuenta(d.getTipoCuenta());
        e.setSaldoInicial(d.getSaldo());
        e.setEstado(d.getEstado());
        e.setClaveUnica(d.getClaveUnica());
        e.setClienteId(d.getClienteId());
        return e;
    }
}
