package com.example.cuenta_mov.infrastructure.adapter.out.persistence.cuenta.entity;

import com.example.cuenta_mov.domain.enums.EstadoCuentaEnum;
import com.example.cuenta_mov.domain.enums.TipoCuenta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "cuenta")
public class CuentaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "entidad")
    private Long entidad;

    @Column(name="numero_cuenta")
    private String numeroCuenta;

    @Column(name = "tipo_cuenta")
    @Enumerated(EnumType.STRING)
    private TipoCuenta tipoCuenta;

    @Column(name = "saldo_inicial")
    private BigDecimal saldoInicial;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    private EstadoCuentaEnum estado;

    @Column(name = "clave_unica")
    private String claveUnica;

    @Column(name = "cliente_id")
    private Long clienteId;


}
