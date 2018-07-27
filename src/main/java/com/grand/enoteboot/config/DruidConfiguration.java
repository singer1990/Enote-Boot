package com.grand.enoteboot.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author GrandX
 */
@Configuration
public class DruidConfiguration {

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        // 白名单
        servletRegistrationBean.addInitParameter("allow","");
        // 黑名单
        servletRegistrationBean.addInitParameter("deny","192.168.1.255");
        // 设置管理用户帐号密码
        servletRegistrationBean.addInitParameter("loginUsername","druid");
        servletRegistrationBean.addInitParameter("loginPassword","qwe123");
        // 是否可以重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean statFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略形式
        filterRegistrationBean.addInitParameter("exclusions","*.js,*.css,*.ico,*.gif,*.jpg,*.png,/druid/*");
        return filterRegistrationBean;
    }
}
