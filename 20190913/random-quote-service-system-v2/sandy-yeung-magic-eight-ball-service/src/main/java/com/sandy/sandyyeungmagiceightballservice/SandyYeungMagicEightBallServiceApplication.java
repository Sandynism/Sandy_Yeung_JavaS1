package com.sandy.sandyyeungmagiceightballservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SandyYeungMagicEightBallServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandyYeungMagicEightBallServiceApplication.class, args);
	}

}
