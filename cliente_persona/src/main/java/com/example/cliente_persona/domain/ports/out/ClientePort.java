package com.example.cliente_persona.domain.ports.out;

import com.example.cliente_persona.domain.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClientePort {
    Optional<Cliente> findById(Long id);
    List<Cliente> findAll();
    Cliente save(Cliente cliente);
    void deleteById(Long id);

    void delete(Cliente cliente);
}
