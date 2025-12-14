package com.example.cuenta_mov.infrastructure.adapter.in.controller.cuenta.dto;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;

public record UpdateCuentaRequest(Long entidad, EstadoCuentaEnum estado) {}
