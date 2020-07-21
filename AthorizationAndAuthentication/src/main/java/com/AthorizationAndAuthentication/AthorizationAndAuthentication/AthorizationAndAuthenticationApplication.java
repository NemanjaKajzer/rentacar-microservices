package com.AthorizationAndAuthentication.AthorizationAndAuthentication;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class AthorizationAndAuthenticationApplication {




	public static void main(String[] args) {
		SpringApplication.run(AthorizationAndAuthenticationApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() { return new RestTemplate(); }


}
