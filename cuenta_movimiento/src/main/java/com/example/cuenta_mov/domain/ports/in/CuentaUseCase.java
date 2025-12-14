package com.example.cuenta_mov.domain.ports.in;

import com.example.cuenta_mov.application.command.cuenta.CuentaCreateCommand;
import com.example.cuenta_mov.application.command.cuenta.CuentaUpdateCommand;
import com.example.cuenta_mov.domain.model.Cuenta;
import com.example.cuenta_mov.domain.model.EstadoCuenta;

import java.util.Date;
import java.util.List;

public interface CuentaUseCase {

    Cuenta findById(Long id);

    Cuenta save(CuentaCreateCommand cliente);

    Cuenta update(Long id, CuentaUpdateCommand request);

    void delete(Long id);

    List<Cuenta> findAll();

    List<EstadoCuenta> getEstadoCuenta(Long idCliente, Date fechaDesde, Date fechaHasta);
}
