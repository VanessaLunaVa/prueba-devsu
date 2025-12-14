CREATE TABLE persona (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    genero VARCHAR(20) NOT NULL,
    edad INT NOT NULL,
    identificacion VARCHAR(50) NOT NULL,
    direccion VARCHAR(150),
    telefono VARCHAR(50),
    PRIMARY KEY (id),
    UNIQUE (identificacion)
);

CREATE TABLE cliente (
    id VARCHAR(200) NOT NULL,
    cliente_id VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(200) NOT NULL,
    estado VARCHAR(50) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_cliente_persona FOREIGN KEY (id) REFERENCES persona(id)
);
