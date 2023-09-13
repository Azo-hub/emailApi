package com.emailApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class EmailApi1Application {

	public static void main(String[] args) {
		SpringApplication.run(EmailApi1Application.class, args);
		
	}

}
