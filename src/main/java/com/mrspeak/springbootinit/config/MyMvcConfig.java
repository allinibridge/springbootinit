package com.mrspeak.springbootinit.config;

import com.mrspeak.springbootinit.component.LoginHandlerInterceptor;
import com.mrspeak.springbootinit.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;



/**
 * @author allinibridge
 * @description 自配springMVC
 *  或者实现WebMvcConfigure接口
 * @date 2019/8/12
 * 加@EnableWebMvc注解全面接管springMVC
 */
@Configuration
public class MyMvcConfig  extends WebMvcConfigurationSupport {
    @Override
    protected void addViewControllers(ViewControllerRegistry registry) {
       registry.addViewController("/nihao").setViewName("add");
        //registry.addResourceHandler("/webjars/**") .addResourceLocations("classpath:/META-INF/resources/webjars/");

    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/webjars/**") .addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**") .addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //super.addInterceptors(registry);
        //spring boot已经做好静态资源不拦截
        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/login.html","/ind","/user/login","/add","/userList");
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }


}
