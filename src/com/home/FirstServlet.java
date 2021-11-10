package com.home;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author GTsung
 * @date 2021/2/6
 */
public class FirstServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getServletContext().getServerInfo());
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("name");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Hello</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("<h1>hello" + name +"</h1>");
        out.println("</body>");

        out.println("</html>");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("first init");
    }
}
