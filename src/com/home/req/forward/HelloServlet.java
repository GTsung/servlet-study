package com.home.req.forward;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GTsung
 * @date 2021/2/23
 */
@WebServlet(urlPatterns = "/hello.do")
public class HelloServlet extends HttpServlet {

    private HelloModel helloModel = new HelloModel();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        String msg = helloModel.getMsg(user);
        request.setAttribute("msg", msg);
        // 转发至下一个servlet
        request.getRequestDispatcher("hello.view")
                .forward(request, response);
    }
}
