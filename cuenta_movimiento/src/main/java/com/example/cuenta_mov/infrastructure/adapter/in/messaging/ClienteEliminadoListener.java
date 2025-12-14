package com.example.cuenta_mov.infrastructure.adapter.in.messaging;

import com.example.cuenta_mov.domain.ports.in.ClienteHandlerUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class ClienteEliminadoListener {

    private static final Logger logger = LoggerFactory.getLogger(ClienteEliminadoListener.class);

    private final ClienteHandlerUseCase clienteHandlerUseCase;

    public ClienteEliminadoListener(ClienteHandlerUseCase procesarClienteEliminadoPort) {
        this.clienteHandlerUseCase = procesarClienteEliminadoPort;
    }

    @KafkaListener(
            topics = "${kafka.topics.cliente-eliminado}",
            groupId = "${spring.kafka.consumer.group-id}",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void consumirClienteEliminado(
            @Payload Long event,
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Header(KafkaHeaders.RECEIVED_PARTITION) int partition,
            @Header(KafkaHeaders.OFFSET) long offset) {

        try {
            logger.info("Evento recibido - Topic: {}, Partition: {}, Offset: {}, Event: {}",
                    topic, partition, offset, event);

            // Procesar el evento
            clienteHandlerUseCase.clienteEliminadoHandler(event);

            logger.info("Evento procesado exitosamente: {}", event);

        } catch (Exception e) {
            logger.error("Error al procesar evento de cliente eliminado: {}", event, e);
            throw e;
        }
    }
}
