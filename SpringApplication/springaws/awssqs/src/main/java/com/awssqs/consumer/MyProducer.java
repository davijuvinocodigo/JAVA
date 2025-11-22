package com.awssqs.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyProducer {

    private static final Logger logger = LoggerFactory.getLogger(MyProducer.class);

    // Injeta um objeto SqsTemplate para interagir com o SQS
    @Autowired
    private SqsTemplate sqsTemplate;

    public void sendMessage(String fila, MyMessage message) {
        sqsTemplate.send(fila, message);
        logger.info("Message producer to SQS: {}", message);
    }
}
