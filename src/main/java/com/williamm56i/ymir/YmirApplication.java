package com.williamm56i.ymir;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
public class YmirApplication {

	public static void main(String[] args) {
		SpringApplication.run(YmirApplication.class, args);
	}

}
