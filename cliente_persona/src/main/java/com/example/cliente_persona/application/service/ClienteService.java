package com.example.cliente_persona.application.service;

import com.example.cliente_persona.application.command.ClienteCommand;
import com.example.cliente_persona.domain.model.Cliente;
import com.example.cliente_persona.domain.model.ClienteEliminadoEvent;
import com.example.cliente_persona.domain.ports.in.ClienteUseCase;
import com.example.cliente_persona.domain.ports.out.ClienteEventPublisherPort;
import com.example.cliente_persona.domain.ports.out.ClientePort;
import com.example.cliente_persona.infrastructure.adapter.out.persistence.mapper.ClienteMapper;
import com.example.cliente_persona.util.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class ClienteService implements ClienteUseCase {

    private final ClienteEventPublisherPort eventPublisher;
    private final ClientePort clientePort;
    private final ClienteMapper mapper;

    @Override
    public Cliente findById(Long id) {
        return clientePort.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente con id " + id + " no existe"));
    }

    @Override
    public Cliente save(ClienteCommand clienteCommand) {
        Cliente cliente = new Cliente(clienteCommand.id(), clienteCommand.nombre(), clienteCommand.genero(), clienteCommand.edad(),
                clienteCommand.identificacion(), clienteCommand.direccion(),
                clienteCommand.telefono(), clienteCommand.clienteId(), clienteCommand.password(),
                clienteCommand.estado());
        return clientePort.save(cliente);
    }

    @Override
    public Cliente update(Long id, ClienteCommand request) {
        return clientePort.findById(id)
                .map(mapper::toEntity)
                .map(clienteExistente -> {
                    clienteExistente.setNombre(request.nombre());
                    clienteExistente.setIdentificacion(request.identificacion());
                    clienteExistente.setDireccion(request.direccion());
                    clienteExistente.setTelefono(request.telefono());
                    clienteExistente.setGenero(request.genero());
                    clienteExistente.setEdad(request.edad());
                    clienteExistente.setEstado(request.estado());
                    clienteExistente.setPassword(request.password());
                    // Guardar cambios
                    return clientePort.save(mapper.toDomain(clienteExistente));
                })
                .orElseThrow(() -> new NotFoundException("Cliente con id " + id + " no existe"));
    }

    @Override
    public void delete(Long id) {
        Cliente cliente = clientePort.findById(id)
                .orElseThrow(() -> new NotFoundException("Cliente no existe"));

        clientePort.delete(cliente);

        eventPublisher.publishClienteEliminado(
                new ClienteEliminadoEvent(id)
        );
    }

    @Override
    public List<Cliente> findAll() {
        return clientePort.findAll();
    }
}
