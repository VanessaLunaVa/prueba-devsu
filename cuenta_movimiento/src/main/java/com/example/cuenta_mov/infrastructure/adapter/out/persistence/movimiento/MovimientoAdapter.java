package com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento;

import com.example.cuenta_mov.domain.model.Movimiento;
import com.example.cuenta_mov.domain.ports.out.MovimientoPort;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.mapper.MovimientoEntityMapper;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.entity.MovimientoEntity;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.repository.MovimientoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
@Slf4j
public class MovimientoAdapter implements MovimientoPort {

    private final MovimientoRepository movRepository;
    private final MovimientoEntityMapper mapper;

    @Override
    public Optional<Movimiento> findById(Long id) {
        return movRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Movimiento> findAll() {
        return movRepository.findAll()
                .stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public Movimiento save(Movimiento movimiento) {
        MovimientoEntity save = movRepository.save(mapper.toEntity(movimiento));
        return mapper.toDomain(save);
    }

    @Override
    public void deleteById(Long id) {
        movRepository.deleteById(id);
    }

    @Override
    public List<Movimiento> findByCuentaAndFechaBetween(Long cuentaId, LocalDateTime fechaInicial, LocalDateTime fechaFinal) {
        return movRepository.findByCuentaIdAndFechaBetween(cuentaId, fechaInicial, fechaFinal).stream()
                .map(mapper::toDomain).toList();
    }
}
