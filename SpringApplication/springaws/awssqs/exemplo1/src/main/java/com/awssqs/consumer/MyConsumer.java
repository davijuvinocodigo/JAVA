package com.awssqs.consumer;

import io.awspring.cloud.sqs.annotation.SqsListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MyConsumer {

    private static final Logger logger = LoggerFactory.getLogger(MyConsumer.class);

    /**
     * Método que escuta a fila SQS e processa novos message.
     *
     * @param message A message recebido da fila SQS
     */
    @SqsListener("my-queue")
    public void listen(@Payload MyMessage message) {
        try {
            logger.info("Message consumer of SQS: {}", message);
            // Aqui você pode processar o message, como salvá-lo no banco de dados ou enviá-lo para outro serviço

        } catch (Exception e) {
            logger.error("Error processing order: {}", e.getMessage());
            // Lidar com exceções durante o processamento da message
        }

    }
}
