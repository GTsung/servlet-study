package com.home.filt;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;

/**
 * @author GTsung
 * @date 2021/3/6
 */
//  <filter>
//        <filter-name>ServletFilter</filter-name>
//        <filter-class>com.home.filt.ServletFilter</filter-class>
//        <async-supported>true</async-supported>
//  </filter>
@WebFilter(filterName = "servletFilter", urlPatterns = "/*",
        asyncSupported = true,
        initParams = {@WebInitParam(name="s",value = "")})
public class ServletFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long begin = System.currentTimeMillis();
        // 在此处调用下一个filter进行下一步操作
        chain.doFilter(request, response);
        filterConfig.getServletContext().log("request process in " + (System.currentTimeMillis() - begin));
    }
}
