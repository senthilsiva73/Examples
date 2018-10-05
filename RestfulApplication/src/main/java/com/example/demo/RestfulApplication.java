package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo"})
@PropertySource(value = { "classpath:application.properties" })
public class RestfulApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulApplication.class, args);
	}
}
