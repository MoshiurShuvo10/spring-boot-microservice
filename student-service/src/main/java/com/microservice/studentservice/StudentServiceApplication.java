package com.microservice.studentservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableFeignClients("com.microservice.studentservice.feignClients")
@EnableEurekaClient
public class StudentServiceApplication {

	// @Value pulls the corresponding value of its parameter from application.properties
	@Value("${address.service.url}")
	private String addressServiceUrl ;
	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}


	// We're using this webClient to call address service. This bean can be used all over the entire application as
	// annotated with @Bean
	@Bean
	public WebClient webClient() {
		WebClient addressWebClient = WebClient.builder().baseUrl(addressServiceUrl).build() ;
		return addressWebClient ;
	}
}
