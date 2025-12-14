package com.example.cliente_persona.infrastructure.adapter.out.messaging;

import com.example.cliente_persona.domain.model.ClienteEliminadoEvent;
import com.example.cliente_persona.domain.ports.out.ClienteEventPublisherPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class ClienteEventPublisherAdapter implements ClienteEventPublisherPort {

    private static final Logger logger = LoggerFactory.getLogger(ClienteEventPublisherAdapter.class);

    private final KafkaTemplate<String, Long> kafkaTemplate;
    private final String topicName;

    public ClienteEventPublisherAdapter(
            KafkaTemplate<String, Long> kafkaTemplate,
            @Value("${kafka.topics.cliente-eliminado}") String topicName) {
        this.kafkaTemplate = kafkaTemplate;
        this.topicName = topicName;
    }

    @Override
    public void publishClienteEliminado(ClienteEliminadoEvent event) {
        logger.info("Publicando evento ClienteEliminado: {}", event);

        CompletableFuture<SendResult<String, Long>> future =
                kafkaTemplate.send(topicName, event.clienteId().toString(), event.clienteId());

        future.whenComplete((result, ex) -> {
            if (ex == null) {
                logger.info("Evento publicado exitosamente: {} con offset: {}",
                        event.clienteId(),
                        result.getRecordMetadata().offset());
            } else {
                logger.error("Error al publicar evento: {}", event.clienteId(), ex);
            }
        });

    }
}
