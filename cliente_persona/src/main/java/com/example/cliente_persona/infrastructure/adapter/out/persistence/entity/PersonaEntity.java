package com.example.cliente_persona.infrastructure.adapter.out.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "genero")
    private String genero;
    @Column(name = "edad")
    private int edad;
    @Column(name = "identificacion")
    private String identificacion;
    @Column(name = "direccion")
    private String direccion;
    @Column(name = "telefono")
    private String telefono;
}
