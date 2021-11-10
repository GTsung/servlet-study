package com.home.req.listen;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author GTsung
 * @date 2021/3/6
 */
@WebServlet(urlPatterns = "/attribute/request")
public class AttributeRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("add1", "wokao");
        request.setAttribute("add1", "wokao2");
        request.removeAttribute("add1");
    }
}
