package com.capg.otms.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class OtmsUserMsApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(OtmsUserMsApplication.class, args);
	}
	@Bean
	
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	
}

}