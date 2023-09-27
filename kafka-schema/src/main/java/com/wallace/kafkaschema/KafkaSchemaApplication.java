package com.wallace.kafkaschema;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaSchemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaSchemaApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			for (int i = 0; i <= 10; i ++) {
				kafkaTemplate.send("amigoscode", "Hello kafka: " + i);
			}
		};
	}

}
