package com.example.cliente_persona.infrastructure.adapter.out.persistence;

import com.example.cliente_persona.domain.model.Cliente;
import com.example.cliente_persona.domain.ports.out.ClientePort;
import com.example.cliente_persona.infrastructure.adapter.out.persistence.entity.ClienteEntity;
import com.example.cliente_persona.infrastructure.adapter.out.persistence.mapper.ClienteMapper;
import com.example.cliente_persona.infrastructure.adapter.out.persistence.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository
@Slf4j
public class ClienteAdapter implements ClientePort {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper mapper;

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll()
                .stream()
                .map(mapper::toDomain).toList();
    }

    @Override
    public Cliente save(Cliente cliente) {
        ClienteEntity save = clienteRepository.save(mapper.toEntity(cliente));
        return mapper.toDomain(save);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteRepository.delete(mapper.toEntity(cliente));
    }
}
