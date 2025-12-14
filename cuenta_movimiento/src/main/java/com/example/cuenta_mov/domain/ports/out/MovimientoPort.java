package com.example.cuenta_mov.domain.ports.out;

import com.example.cuenta_mov.domain.model.Movimiento;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovimientoPort {
    Optional<Movimiento> findById(Long id);
    List<Movimiento> findAll();
    Movimiento save(Movimiento movimiento);
    void deleteById(Long id);
    List<Movimiento> findByCuentaAndFechaBetween(Long cuentaId, LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
