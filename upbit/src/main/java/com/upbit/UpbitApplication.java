package com.upbit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class UpbitApplication {

	public static void main(String[] args) {
		SpringApplication.run(UpbitApplication.class, args);
	}

}
