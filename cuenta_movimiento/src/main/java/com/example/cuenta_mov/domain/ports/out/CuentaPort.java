package com.example.cuenta_mov.domain.ports.out;

import com.example.cuenta_mov.domain.model.Cuenta;

import java.util.List;
import java.util.Optional;

public interface CuentaPort {
    Optional<Cuenta> findById(Long id);
    List<Cuenta> findAll();
    Cuenta save(Cuenta cuenta);
    void deleteById(Long id);
    List<Cuenta> findAllByClienteId(Long clienteId);
}
