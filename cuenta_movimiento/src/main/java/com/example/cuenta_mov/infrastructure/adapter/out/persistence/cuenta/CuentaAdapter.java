package com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta;

import com.example.cuenta_mov.domain.model.Cuenta;
import com.example.cuenta_mov.domain.ports.out.CuentaPort;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.entity.CuentaEntity;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.mapper.CuentaEntityMapper;
import com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.repository.CuentaRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
@Slf4j
public class CuentaAdapter implements CuentaPort {

    private final CuentaRepository cuentaRepository;
    private final CuentaEntityMapper mapper;

    @Override
    public Optional<Cuenta> findById(Long id) {
        return cuentaRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Cuenta> findAll() {
        return cuentaRepository.findAll()
                .stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public Cuenta save(Cuenta cuenta) {
        CuentaEntity save = cuentaRepository.save(mapper.toEntity(cuenta));
        return mapper.toDomain(save);
    }

    @Override
    public void deleteById(Long id) {
        cuentaRepository.deleteById(id);
    }

    @Override
    public List<Cuenta> findAllByClienteId(Long clienteId) {
        return cuentaRepository.findByClienteId(clienteId).stream()
                .map(mapper::toDomain).toList();
    }
}
