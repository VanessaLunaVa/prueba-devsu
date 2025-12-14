package com.example.cliente_persona.infrastructure.adapter.in.controller.mapper;

import com.example.cliente_persona.application.command.ClienteCommand;
import com.example.cliente_persona.infrastructure.adapter.in.controller.dto.ClienteRequest;

public class ClienteRequestMapper {

    public static ClienteCommand toCommand(ClienteRequest cliente) {
        return new ClienteCommand(null, cliente.nombre(), cliente.genero(),
                cliente.edad(), cliente.identificacion(),
                cliente.direccion(), cliente.telefono(), cliente.clienteId(), cliente.password(),
                cliente.estado());
    }
}
