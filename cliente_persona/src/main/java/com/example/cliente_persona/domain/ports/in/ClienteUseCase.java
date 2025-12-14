package com.example.cliente_persona.domain.ports.in;

import com.example.cliente_persona.application.command.ClienteCommand;
import com.example.cliente_persona.domain.model.Cliente;

import java.util.List;

public interface ClienteUseCase {

    Cliente findById(Long id);

    Cliente save(ClienteCommand cliente);

    Cliente update(Long id, ClienteCommand request);

    void delete(Long id);

    List<Cliente> findAll();
}
