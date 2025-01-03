package com.panditya.elements_service_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication
public class ElementsServiceUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElementsServiceUserApplication.class, args);
	}


}
