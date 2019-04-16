package com.jxc.authentication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = {"com.jxc"})
public class AuthenticationApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AuthenticationApplication.class);
	}
	
}
