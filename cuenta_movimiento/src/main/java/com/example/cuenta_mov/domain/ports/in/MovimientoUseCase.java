package com.example.cuenta_mov.domain.ports.in;

import com.example.cuenta_mov.application.command.movimiento.MovimientoCommand;
import com.example.cuenta_mov.domain.model.EstadoCuentaMovimientos;
import com.example.cuenta_mov.domain.model.Movimiento;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MovimientoUseCase {
    Movimiento findById(Long id);

    Movimiento save(MovimientoCommand cliente);

    Movimiento update(Long id, MovimientoCommand request);

    void delete(Long id);

    List<Movimiento> findAll();

    List<EstadoCuentaMovimientos> getEstadoCuentaMovimientos(Long clienteId,
                                                             LocalDateTime fechaDesde, LocalDateTime fechaHasta);
}
