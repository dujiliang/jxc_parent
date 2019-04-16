package com.jxc.employment_center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.jxc.*"})
@MapperScan(basePackages = {"com.jxc.employment_center.dao"})
public class EmploymentCenterApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(EmploymentCenterApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EmploymentCenterApplication.class);
	}
}
