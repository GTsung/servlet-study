package com.home.life;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

/**
 * @author GTsung
 * @date 2021/3/1
 */
@WebServlet(name = "servletConfigDemo", urlPatterns = {"/conf"},
    initParams = {
        @WebInitParam(name ="param1", value = "v1"),
        @WebInitParam(name ="param2", value = "v2")
    })
public class ServletConfigDemo extends HttpServlet {

    private String param1;
    private String param2;

    public void init() {
        param1 = getServletConfig().getInitParameter("param1");
        param2 = getServletConfig().getInitParameter("param2");
        System.out.println(param1);
        System.out.println(param2);
    }
}
