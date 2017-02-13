package com.nyshup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class VerbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerbServiceApplication.class, args);
	}
}
