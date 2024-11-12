package com.williamm56i.ymir;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition
@SpringBootApplication
@EnableEncryptableProperties
public class YmirApplication {

	public static void main(String[] args) {
		SpringApplication.run(YmirApplication.class, args);
	}

}
