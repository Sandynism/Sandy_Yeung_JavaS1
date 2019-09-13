package com.sandy.sandyyeungrandomquoteservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SandyYeungRandomQuoteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SandyYeungRandomQuoteServiceApplication.class, args);
	}

}
