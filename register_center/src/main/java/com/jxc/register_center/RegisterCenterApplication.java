package com.jxc.register_center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.jxc.*"})
@MapperScan(basePackages = {"com.jxc.register_center.dao"})
public class RegisterCenterApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(RegisterCenterApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(RegisterCenterApplication.class);
	}
}
