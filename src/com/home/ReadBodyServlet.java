package com.home;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author GTsung
 * @date 2021/2/21
 */
@WebServlet(urlPatterns = {"/read"})
public class ReadBodyServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // getReader()得到BufferedReader
        BufferedReader reader = request.getReader();
        String input = null;
        String body = "";
        while ((input = reader.readLine()) != null) {
            body = body + input;
        }
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<head>");
        writer.println("<title>body view</title>");
        writer.println("</head>");
        writer.println("<body>");
        writer.println(body);
        writer.println("</body>");
        writer.println("</html>");
    }
}
