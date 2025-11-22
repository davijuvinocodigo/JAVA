package com.awssqs;

import com.awssqs.consumer.MyMessage;
import com.awssqs.consumer.MyProducer;
import io.awspring.cloud.sqs.operations.SqsTemplate;
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
		myProducer.sendMessage("https://localhost.localstack.cloud:4566/000000000000/minha-fila", new MyMessage("meu valor de start via producer"));
	}

}
