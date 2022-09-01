package com.qa.cinema.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringBootConfiguration;

@SpringBootConfiguration
public class AppConfig {

	@Bean
	public ModelMapper getMapper() {
		return new ModelMapper();
	}
	
}
