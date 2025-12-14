package com.example.cuenta_mov.application.service;

import com.example.cuenta_mov.domain.model.Cuenta;
import com.example.cuenta_mov.domain.ports.in.ClienteHandlerUseCase;
import com.example.cuenta_mov.domain.ports.out.CuentaPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClienteHandlerService implements ClienteHandlerUseCase {

    private static final Logger logger = LoggerFactory.getLogger(ClienteHandlerService.class);

    private final CuentaPort cuentaPort;

    @Override
    @Transactional
    public void clienteEliminadoHandler(Long event) {
        List<Cuenta> cuentas = cuentaPort
                .findAllByClienteId(event);

        cuentas.forEach(cuenta -> {
            cuenta.cancelarCuentas();
            cuentaPort.save(cuenta);
            logger.info("Cuenta {} actualizada por eliminación del cliente {}",
                    cuenta.getNumeroCuenta(), event);
        });
    }
}
