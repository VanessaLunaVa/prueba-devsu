CREATE TABLE cuenta (
    id BIGINT NOT NULL AUTO_INCREMENT,
    entidad BIGINT NOT NULL,
    numero_cuenta VARCHAR(50) NOT NULL UNIQUE,
    tipo_cuenta VARCHAR(50) NOT NULL,
    saldo_inicial DECIMAL(18,2) NOT NULL,
    estado VARCHAR(100) NOT NULL,
    cliente_id BIGINT NOT NULL,
    clave_unica VARCHAR(50) NOT NULL,
    UNIQUE (clave_unica),
    PRIMARY KEY (id)
);

CREATE TABLE movimiento (
    id BIGINT NOT NULL AUTO_INCREMENT,
    entidad BIGINT NOT NULL,
    fecha TIMESTAMP NOT NULL,
    tipo_movimiento BIGINT NOT NULL,
    valor DECIMAL(18,2) NOT NULL,      -- puede ser positivo o negativo
    saldo DECIMAL(18,2) NOT NULL,      -- saldo disponible después del movimiento
    cuenta_id BIGINT NOT NULL,
    clave_unica VARCHAR(50) NOT NULL,
    UNIQUE (clave_unica),
    PRIMARY KEY (id),
    CONSTRAINT fk_movimiento_cuenta FOREIGN KEY (cuenta_id) REFERENCES cuenta(id)
);
