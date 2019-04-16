package com.jxc.short_message.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jxc.short_message.interceptor.UrlInterceptor;


@Configuration
public class UrlWebConfigurer implements WebMvcConfigurer {
    @Autowired
    private UrlInterceptor urlInterceptor;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	
        registry.addInterceptor(urlInterceptor).addPathPatterns("/**");
    }
 }

