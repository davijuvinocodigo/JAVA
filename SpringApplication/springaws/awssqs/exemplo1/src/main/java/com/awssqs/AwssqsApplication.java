package com.awssqs;

import com.awssqs.consumer.MyMessage;
import com.awssqs.consumer.MyProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AwssqsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(AwssqsApplication.class, args);
	}

	@Autowired
	private MyProducer myProducer;

	@Override
	public void run(String... args) throws Exception {
		// Simulando a criação de uma nova mensagem para enviar à fila SQS
		myProducer.sendMessage("https://localhost.localstack.cloud:4566/000000000000/minha-fila", new MyMessage("Valor de via file SQS"));
	}

}
