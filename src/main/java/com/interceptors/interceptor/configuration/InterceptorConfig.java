package com.interceptors.interceptor.configuration;

import com.interceptors.interceptor.GeneralInterceptor;
import com.interceptors.interceptor.SpecificInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private GeneralInterceptor generalInterceptor;
    @Autowired
    private SpecificInterceptor specificInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(generalInterceptor).order(2);
        registry.addInterceptor(specificInterceptor).order(1).addPathPatterns("/pathSpecific/**");
    }
}
