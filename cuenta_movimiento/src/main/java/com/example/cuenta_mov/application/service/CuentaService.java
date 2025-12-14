package com.example.cuenta_mov.application.service;

import com.example.cuenta_mov.application.command.cuenta.CuentaCreateCommand;
import com.example.cuenta_mov.application.command.cuenta.CuentaUpdateCommand;
import com.example.cuenta_mov.domain.model.Cuenta;
import com.example.cuenta_mov.domain.model.EstadoCuenta;
import com.example.cuenta_mov.domain.ports.in.CuentaUseCase;
import com.example.cuenta_mov.domain.ports.out.CuentaPort;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.mapper.CuentaEntityMapper;
import com.example.cuenta_mov.util.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class CuentaService implements CuentaUseCase {

    private final CuentaPort cuentaPort;
    private final CuentaEntityMapper mapper;

    @Override
    public Cuenta findById(Long id) {
        return cuentaPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Cuenta con id " + id + " no existe"));
    }

    @Override
    public Cuenta save(CuentaCreateCommand cuenta) {
        Cuenta cuentaToSave = Cuenta.create(cuenta.clienteId(), cuenta.entidad(),
                cuenta.tipoCuenta(), cuenta.saldoInicial());
        return cuentaPort.save(cuentaToSave);
    }

    @Override
    public Cuenta update(Long id, CuentaUpdateCommand request) {
        return cuentaPort.findById(id)
                .map(mapper::toEntity)
                .map(cuentaExistente -> {
                    cuentaExistente.setEstado(request.estado());
                    cuentaExistente.setEntidad(request.entidad());
                    return cuentaPort.save(mapper.toDomain(cuentaExistente));
                })
                .orElseThrow(() -> new NotFoundException("Cuenta con id " + id + " no existe"));
    }

    @Override
    public void delete(Long id) {
        cuentaPort.deleteById(id);
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaPort.findAll();
    }

    @Override
    public List<EstadoCuenta> getEstadoCuenta(Long idCliente, Date fechaDesde, Date fechaHasta) {
        List<Cuenta> cuentas = cuentaPort.findAllByClienteId(idCliente);
        return cuentas.stream().map(c -> new EstadoCuenta(c.getEntidad(), c.getNumeroCuenta(),
                c.getTipoCuenta(), c.getSaldo(), c.getEstado())).toList();
    }
}
