package com.awssqs.consumer;

import io.awspring.cloud.sqs.operations.SqsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyProducer {

    @Autowired
    private SqsTemplate sqsTemplate;

    public void sendMessage(String fila, MyMessage message) {
        sqsTemplate.send(fila, message);
    }
}
