package com.example.cliente_persona.domain.model;

import lombok.Getter;

@Getter
public class Cliente extends Persona {

    private final String clienteId;
    private final String password;
    private final String estado;

    public Cliente(Long id, String nombre, String genero, int edad, String identificacion, String direccion, String telefono, String clienteId, String password, String estado) {
        super(id, nombre, genero, edad, identificacion, direccion, telefono);
        this.clienteId = clienteId;
        this.password = password;
        this.estado = estado;
    }
}
