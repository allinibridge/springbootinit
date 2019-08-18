package com.mrspeak.springbootinit.component;


import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author allinibridge
 * @description 自定义区域化信息解析器
 * @date 2019/8/14
 */
public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String langua = request.getParameter("l");
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(langua)){
         String[] ls = langua.split("_");
         locale = new Locale(ls[0],ls[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
