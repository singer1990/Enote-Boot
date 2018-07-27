package com.grand.enoteboot.config;

import com.grand.enoteboot.interceptor.LogInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * @author GrandX
 */
@Configuration
public class InterceptorConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public LogInterceptor logInterceptor(){
        return new LogInterceptor();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(logInterceptor()).addPathPatterns("/**");
    }
}
