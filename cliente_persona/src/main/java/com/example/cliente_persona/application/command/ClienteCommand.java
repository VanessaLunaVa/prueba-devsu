package com.example.cliente_persona.application.command;

public record ClienteCommand(Long id, String nombre, String genero, int edad, String identificacion,
                             String direccion, String telefono,
                             String clienteId, String password, String estado) {
}
