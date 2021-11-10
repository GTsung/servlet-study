package com.home.filt.req;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author GTsung
 * @date 2021/3/6
 */
@WebFilter(filterName = "encode", urlPatterns = "/encode",
        initParams = {@WebInitParam(name = "encode", value = "UTF-8")})
public class EncodeFilter implements Filter {

    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("encode");
    }

    @Override
    public void destroy() {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        if ("GET".equals(req.getMethod())) {
            // get方法只能手动转换字符编码
            req = new EncodingWrapper(req, encoding);
        } else {
            req.setCharacterEncoding(encoding);
        }
        chain.doFilter(req, response);
    }
}
