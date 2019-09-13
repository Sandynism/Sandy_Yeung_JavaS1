package com.sandy.sandyyeungserviceregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SandyYeungServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandyYeungServiceRegistryApplication.class, args);
	}

}
