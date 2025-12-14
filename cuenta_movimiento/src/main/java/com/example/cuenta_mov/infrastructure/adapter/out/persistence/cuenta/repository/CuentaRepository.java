package com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.repository;

import com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.entity.CuentaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CuentaRepository extends JpaRepository<CuentaEntity, Long> {


    List<CuentaEntity> findByClienteId(Long clienteId);
}
