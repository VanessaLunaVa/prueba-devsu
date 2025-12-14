package com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.repository;

import com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.entity.MovimientoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MovimientoRepository extends JpaRepository<MovimientoEntity, Long> {
    List<MovimientoEntity> findByCuentaIdAndFechaBetween(Long cuentaId,
                                                         LocalDateTime fechaInicial, LocalDateTime fechaFinal);
}
