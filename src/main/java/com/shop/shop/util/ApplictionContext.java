package com.shop.shop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

@Component
public class ApplictionContext implements ServletContextAware {

    private static final Logger log = LoggerFactory.getLogger(ApplicationContext.class);
    @Override
    public void setServletContext(ServletContext servletContext) {
        log.info("网站根目录:"+servletContext.getContextPath());
        servletContext.setAttribute("ctx", servletContext.getContextPath());
        servletContext.setAttribute("systemName", "后台管理系统");


    }
}
