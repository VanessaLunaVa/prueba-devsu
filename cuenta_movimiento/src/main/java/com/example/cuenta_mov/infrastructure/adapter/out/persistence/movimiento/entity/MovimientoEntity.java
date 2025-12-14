package com.example.cuenta_mov.infrastructure.adapter.out.persistence.movimiento.entity;

import com.example.cuenta_mov.domain.enums.TipoMovimiento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "movimiento")
@Inheritance(strategy = InheritanceType.JOINED)
public class MovimientoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "entidad")
    private Long entidad;
    @Column(name = "fecha")
    private LocalDateTime fecha;
    @Column(name = "tipo_movimiento")
    @Enumerated(EnumType.STRING)
    private TipoMovimiento tipoMovimiento;
    @Column(name = "valor")
    private BigDecimal valor;
    @Column(name = "saldo")
    private BigDecimal saldo;
    @Column(name = "cuenta_id")
    private Long cuentaId;
    @Column(name = "clave_unica")
    private String claveUnica;
}
