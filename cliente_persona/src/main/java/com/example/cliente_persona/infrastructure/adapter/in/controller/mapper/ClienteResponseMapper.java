package com.example.cliente_persona.infrastructure.adapter.in.controller.mapper;

import com.example.cliente_persona.domain.model.Cliente;
import com.example.cliente_persona.infrastructure.adapter.in.controller.dto.ClienteResponse;

public class ClienteResponseMapper {

    public static ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(cliente.getId(), cliente.getNombre(), cliente.getGenero(),
                cliente.getEdad(), cliente.getIdentificacion(), cliente.getDireccion(),
                cliente.getTelefono(), cliente.getClienteId(), cliente.getPassword(), cliente.getEstado());
    }
}
