package com.home.context;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author GTsung
 * @date 2021/3/2
 */
//@WebListener // 使用注解
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // servletContextEvent封装了servletContext
        ServletContext servletContext = sce.getServletContext();
        String v = servletContext.getInitParameter("ava");
        servletContext.setAttribute("ava", v);
        System.out.println(v);

        // 可以在容器初始化时对cookie进行设置
        servletContext.getSessionCookieConfig().setName("jj");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
