package com.fnhackathon.DataConsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.fnhackathon")
public class DataConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataConsumerApplication.class, args);
	}

}
