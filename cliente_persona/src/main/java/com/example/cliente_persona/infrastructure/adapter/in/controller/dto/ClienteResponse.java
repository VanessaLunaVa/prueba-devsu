package com.example.cliente_persona.infrastructure.adapter.in.controller.dto;

public record ClienteResponse(Long id, String nombre, String genero, int edad, String identificacion,
                              String direccion, String telefono,
                              String clienteId, String password, String estado) {
}
