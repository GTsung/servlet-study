package com.home.life;

import javax.servlet.http.HttpServlet;

/**
 * @author GTsung
 * @date 2021/3/1
 */
public class ServletConfigDemo2 extends HttpServlet {

    private String para;

    public void init() {
        System.out.println(getServletConfig().getInitParameter("para1"));
    }
}
