package com.mrspeak.springbootinit.config;


import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author allinibridge
 * @description druid配置文件
 * @date 2019/8/20
 */
@Configuration
public class DruidConfig {
    /*@ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }*/

    //配置Druid监控
    //1、配置一个管理后台的Servlet
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        Map<String,String> initParameter = new HashMap<>();
        initParameter.put("loginUsername","admin");
        initParameter.put("loginPassword","123456");
        initParameter.put("allow","");
        initParameter.put("deny","192.168.0.198");
        registrationBean.setInitParameters(initParameter);
        return registrationBean;
    }
    //2、配置一个web监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();

        bean.setFilter(new WebStatFilter());
        Map<String,String> initParameter = new HashMap<>();
        initParameter.put("exclusions","*.js,*css,/druid/*");
        bean.setInitParameters(initParameter);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}
