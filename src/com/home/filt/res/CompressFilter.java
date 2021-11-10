package com.home.filt.res;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

/**
 * @author GTsung
 * @date 2021/3/6
 */
@WebFilter(filterName = "CompressFilter", urlPatterns = "/compress")
public class CompressFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String encoding = req.getHeader("accept-encoding");
        // 是否接受gzip压缩
        if ((encoding != null) && (encoding.contains("gzip"))) {
            // 创建响应封装器
            CompressionWrapper wrapper = new CompressionWrapper(res);
            // 设置响应内容编码为gzip
            wrapper.setHeader("content-encoding", "gzip");
            chain.doFilter(request, wrapper);
            GZIPOutputStream gzipOutputStream = wrapper.getGZipOutputStream();
            if (null != gzipOutputStream) {
                gzipOutputStream.finish();
            }
        } else {
            chain.doFilter(request, response);
        }
    }
}
