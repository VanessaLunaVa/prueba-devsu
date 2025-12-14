package com.example.cuenta_mov.application.service;


import com.example.cuenta_mov.application.command.movimiento.MovimientoCommand;
import com.example.cuenta_mov.domain.model.Cuenta;
import com.example.cuenta_mov.domain.model.EstadoCuentaMovimientos;
import com.example.cuenta_mov.domain.model.Movimiento;
import com.example.cuenta_mov.domain.ports.in.MovimientoUseCase;
import com.example.cuenta_mov.domain.ports.out.CuentaPort;
import com.example.cuenta_mov.domain.ports.out.MovimientoPort;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.mapper.MovimientoEntityMapper;
import com.example.cuenta_mov.util.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class MovimientoService implements MovimientoUseCase {

    private final MovimientoPort movimientoPort;
    private final CuentaPort cuentaPort;
    private final MovimientoEntityMapper mapper;

    @Override
    public Movimiento findById(Long id) {
        return movimientoPort.findById(id)
                .orElseThrow(() -> new NotFoundException("Movimiento con id " + id + " no existe"));
    }

    @Override
    public Movimiento save(MovimientoCommand mov) {
        Cuenta cuenta = cuentaPort.findById(mov.cuentaId())
                .orElseThrow(() -> new NotFoundException("Cuenta con id " + mov.cuentaId() + " no existe"));

        Movimiento movimiento = cuenta.registrarMovimiento(mov.valor(), mov.tipoMovimiento(), mov.entidad());
        Movimiento save = movimientoPort.save(movimiento);
        cuentaPort.save(cuenta);
        return save;
    }

    @Override
    public Movimiento update(Long id, MovimientoCommand request) {
        return movimientoPort.findById(id)
                .map(mapper::toEntity)
                .map(movimientoExistente -> {
                    movimientoExistente.setTipoMovimiento(request.tipoMovimiento());
                    movimientoExistente.setEntidad(request.entidad());
                    movimientoExistente.setValor(request.valor());
                    return movimientoPort.save(mapper.toDomain(movimientoExistente));
                })
                .orElseThrow(() -> new NotFoundException("Movimiento con id " + id + " no existe"));
    }

    @Override
    public void delete(Long id) {
        movimientoPort.deleteById(id);
    }

    @Override
    public List<Movimiento> findAll() {
        return movimientoPort.findAll();
    }

    @Override
    public List<EstadoCuentaMovimientos> getEstadoCuentaMovimientos(Long clienteId, LocalDateTime fechaDesde,
                                                                    LocalDateTime fechaHasta) {
        List<Cuenta> cuentas = cuentaPort.findAllByClienteId(clienteId);

        return cuentas.stream()
                .map(c -> {
                    List<Movimiento> byCuenta = movimientoPort.findByCuentaAndFechaBetween(
                            c.getId(), fechaDesde, fechaHasta);

                    return new EstadoCuentaMovimientos(
                            c.getEntidad(),
                            c.getNumeroCuenta(),
                            c.getTipoCuenta(),
                            c.getSaldo(),
                            c.getEstado(),
                            byCuenta
                    );
                })
                .toList();
    }
}
