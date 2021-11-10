package com.home.req;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author GTsung
 * @date 2021/2/23
 */
@WebServlet(urlPatterns = "/includeOne")
public class IncludeOneServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter writer = response.getWriter();
        writer.println("includeOne===");
        RequestDispatcher dispatcher = request.getRequestDispatcher("includeTwo");
        dispatcher.include(request, response);
        writer.println("includeTwo===");
        writer.close();
    }
}
