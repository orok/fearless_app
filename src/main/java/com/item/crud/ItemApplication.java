package com.item.crud;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition
public class ItemApplication {
	public static void main(String[] args) {
		SpringApplication.run(ItemApplication.class, args);
	}
}
