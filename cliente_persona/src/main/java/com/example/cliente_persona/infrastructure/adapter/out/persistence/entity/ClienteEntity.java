package com.example.cliente_persona.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class ClienteEntity extends PersonaEntity {

    private String clienteId;

    @Column(name = "password")
    private String password;

    @Column(name = "estado")
    private String estado;

}
