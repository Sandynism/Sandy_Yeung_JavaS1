package com.trilogyed.springconfigserverexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringConfigServerExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringConfigServerExampleApplication.class, args);
	}

}
