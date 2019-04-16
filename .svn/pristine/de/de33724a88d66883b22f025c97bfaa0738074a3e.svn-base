package com.jxc.employment_center.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jxc.employment_center.interceptor.AuthorizationInterceptor;
import com.jxc.employment_center.resolver.LoginAllPermissionHandlerMethodArgumentResolver;
import com.jxc.employment_center.resolver.LoginChildHandlerMethodArgumentResolver;
import com.jxc.employment_center.resolver.LoginDriverHandlerMethodArgumentResolver;
import com.jxc.employment_center.resolver.LoginOwnerHandlerMethodArgumentResolver;
import com.jxc.employment_center.resolver.LoginTenantryAdminHandlerMethodArgumentResolver;
import com.jxc.employment_center.resolver.LoginTenantryHandlerMethodArgumentResolver;
import com.jxc.employment_center.resolver.LoginUserHandlerMethodArgumentResolver;


/**
 * MVC配置
 *
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
    
    @Autowired
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;
    
    @Autowired
    private LoginOwnerHandlerMethodArgumentResolver loginOwnerHandlerMethodArgumentResolver;
    
    @Autowired
    private LoginDriverHandlerMethodArgumentResolver loginDriverHandlerMethodArgumentResolver;
    
    @Autowired
    private LoginTenantryHandlerMethodArgumentResolver loginTenantryHandlerMethodArgumentResolver;
    
    @Autowired
    private LoginTenantryAdminHandlerMethodArgumentResolver loginTenantryAdminHandlerMethodArgumentResolver;
    
    @Autowired
    private LoginChildHandlerMethodArgumentResolver loginChildHandlerMethodArgumentResolver;
    
    @Autowired
    private LoginAllPermissionHandlerMethodArgumentResolver allPermissionHandlerMethodArgumentResolver;
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	List<String> list = new ArrayList<String>();
    	list.add("/employment_center/**");
    	list.add("/employment_center/**/**");
    	
        registry.addInterceptor(authorizationInterceptor).addPathPatterns(list);
    }
    
    
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserHandlerMethodArgumentResolver);
        argumentResolvers.add(loginOwnerHandlerMethodArgumentResolver);
        argumentResolvers.add(loginDriverHandlerMethodArgumentResolver);
        argumentResolvers.add(loginTenantryHandlerMethodArgumentResolver);
        argumentResolvers.add(loginTenantryAdminHandlerMethodArgumentResolver);
        argumentResolvers.add(loginChildHandlerMethodArgumentResolver);
        argumentResolvers.add(allPermissionHandlerMethodArgumentResolver);
    }
}