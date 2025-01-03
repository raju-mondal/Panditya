package com.panditya.elements_logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ElementsLoggerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElementsLoggerApplication.class, args);
	}

}
