package com.jxc.register_center.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jxc.register_center.interceptor.AuthorizationInterceptor;

/**
 * MVC配置
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	List<String> list = new ArrayList<String>();
    	list.add("/register_center/**");
    	list.add("/register_center/**/**");
    	
        registry.addInterceptor(authorizationInterceptor).addPathPatterns(list);
    }
    
}