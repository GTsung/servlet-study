package com.home.filt.req;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author GTsung
 * @date 2021/3/6
 */
@WebFilter(urlPatterns = "/param", filterName = "paramFilter")
public class ParameterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // 将request的包装类传入过滤器链
        EscapeWrapper escapeWrapper = (EscapeWrapper) request;
        chain.doFilter(escapeWrapper, response);
    }
}
