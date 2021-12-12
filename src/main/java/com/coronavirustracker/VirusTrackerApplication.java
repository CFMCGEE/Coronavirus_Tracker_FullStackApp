package com.coronavirustracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
public class VirusTrackerApplication {

	private static final Logger logger = LoggerFactory.getLogger(VirusTrackerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(VirusTrackerApplication.class, args);
	}

	@GetMapping("/")
	public String home() {
		return "Welcome to AWS, your first Deployment!";
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> { logger.info("Running application!"); };
	}


}
