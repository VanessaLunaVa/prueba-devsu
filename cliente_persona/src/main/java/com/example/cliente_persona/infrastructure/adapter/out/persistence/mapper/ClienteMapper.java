package com.example.cliente_persona.infrastructure.adapter.out.persistence.mapper;

import com.example.cliente_persona.domain.model.Cliente;
import com.example.cliente_persona.infrastructure.adapter.out.persistence.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public Cliente toDomain(ClienteEntity e) {
        return new Cliente(
                e.getId(),
                e.getNombre(),
                e.getGenero(),
                e.getEdad(),
                e.getIdentificacion(),
                e.getDireccion(),
                e.getTelefono(),
                e.getClienteId(),
                e.getPassword(),
                e.getEstado()
        );
    }

    public ClienteEntity toEntity(Cliente d) {
        ClienteEntity e = new ClienteEntity();
        e.setId(d.getId());
        e.setNombre(d.getNombre());
        e.setGenero(d.getGenero());
        e.setEdad(d.getEdad());
        e.setIdentificacion(d.getIdentificacion());
        e.setDireccion(d.getDireccion());
        e.setTelefono(d.getTelefono());
        e.setClienteId(d.getClienteId());
        e.setPassword(d.getPassword());
        e.setEstado(d.getEstado());
        return e;
    }
}
