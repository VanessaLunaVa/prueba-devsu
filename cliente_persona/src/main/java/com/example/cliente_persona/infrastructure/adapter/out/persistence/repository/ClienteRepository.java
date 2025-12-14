package com.example.cliente_persona.infrastructure.adapter.out.persistence.repository;

import com.example.cliente_persona.infrastructure.adapter.out.persistence.entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {


}
