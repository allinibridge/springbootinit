package com.mrspeak.springbootinit.Filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author allinibridge
 * @description 自定义拦截器
 * @date 2019/8/19
 */
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("hello!!!");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
