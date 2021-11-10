package com.home.filt.req;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @author GTsung
 * @date 2021/3/6
 */
public class EncodingWrapper extends HttpServletRequestWrapper {

    private String encoding;

    public EncodingWrapper(HttpServletRequest request, String encoding) {
        super(request);
        this.encoding = encoding;
    }

    @Override
    public String getParameter(String name) {
        String value = getRequest().getParameter(name);
        if (null != value) {
            try {
                // 转换字符编码
                byte[] b = value.getBytes(StandardCharsets.ISO_8859_1);
                value = new String(b, encoding);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return value;
    }
}
