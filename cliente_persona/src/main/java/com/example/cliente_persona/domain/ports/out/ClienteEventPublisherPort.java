package com.example.cliente_persona.domain.ports.out;

import com.example.cliente_persona.domain.model.ClienteEliminadoEvent;

public interface ClienteEventPublisherPort {
    void publishClienteEliminado(ClienteEliminadoEvent event);
}
