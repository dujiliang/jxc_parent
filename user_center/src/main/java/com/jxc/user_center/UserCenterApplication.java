package com.jxc.user_center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages={"com.jxc.*"})
@MapperScan(basePackages = {"com.jxc.user_center.dao"})
public class UserCenterApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UserCenterApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(UserCenterApplication.class);
	}
}
