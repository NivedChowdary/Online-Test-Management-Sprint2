package com.capg.otms.question;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OtmsQuestionMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtmsQuestionMsApplication.class, args);
	}

}