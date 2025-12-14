package com.example.cliente_persona.domain.model;

import lombok.Getter;

@Getter
public class Persona {
    private final Long id;
    private final String nombre;
    private final String genero;
    private final int edad;
    private final String identificacion;
    private final String direccion;
    private final String telefono;

    public Persona(Long id, String nombre, String genero, int edad, String identificacion, String direccion, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
    }
}
