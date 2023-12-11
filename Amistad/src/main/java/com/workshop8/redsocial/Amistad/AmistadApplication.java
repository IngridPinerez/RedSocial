package com.workshop8.redsocial.Amistad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AmistadApplication {
	public static void main(String[] args) {
		SpringApplication.run(AmistadApplication.class, args);
	}

}
