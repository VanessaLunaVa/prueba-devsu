package com.example.cuenta_mov.application.command.cuenta;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;

public record CuentaUpdateCommand(EstadoCuentaEnum estado,
                                  Long entidad) {
}
