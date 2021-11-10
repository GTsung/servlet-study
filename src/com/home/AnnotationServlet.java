package com.home;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @author GTsung
 * @date 2021/2/19
 */
@WebServlet(urlPatterns = {"/sec"})
public class AnnotationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 访问http://localhost:9000/servlet_demo/sec
        String url = request.getRequestURI(); // /servlet_demo/sec
        String contextPath = request.getContextPath(); // contextPath为/servlet_demo
        String path = request.getServletPath(); // path是/sec
        System.out.println("-----------------");

        // 获取单个参数
        String name = request.getParameter("name");
        System.out.println(name);

        // 获取如pass=12&pass=34&pass=44这样的参数
        String[] values = request.getParameterValues("pass");
        Arrays.stream(values).forEach(System.out::println);

        // 类似于getHeaderNames获取所有标头名称
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String enu = enumeration.nextElement();
            System.out.println(enu);
        }

        // key为参数名称，value为参数值数组
        Map<String, String[]> parameterMap = request.getParameterMap();
        parameterMap.forEach((k, v) -> {
            System.out.println(k);
            Arrays.stream(v).forEach(System.out::println);
        });

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String header = headerNames.nextElement();
            String headerValue = request.getHeader(header); // 获取header值
            System.out.println(header + ":" + headerValue);
        }
    }

    @Override
    public void init() throws ServletException {
        System.out.println("sec init");
    }
}
