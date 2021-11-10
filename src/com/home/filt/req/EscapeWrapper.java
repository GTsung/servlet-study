package com.home.filt.req;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author GTsung
 * @date 2021/3/6
 */
public class EscapeWrapper extends HttpServletRequestWrapper {

    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request the {@link HttpServletRequest} to be wrapped.
     * @throws IllegalArgumentException if the request is null
     */
    public EscapeWrapper(HttpServletRequest request) {
        super(request);
    }

    @Override
    public String getParameter(String name) {
        String value = getRequest().getParameter(name);
        // 可以改变参数
        return null== value || value.equals("") ? "empty" : value;
    }
}
