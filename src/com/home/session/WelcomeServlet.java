package com.home.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

/**
 * @author GTsung
 * @date 2021/3/2
 */
@WebServlet(urlPatterns = "/welcome")
public class WelcomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter = response.getWriter();
        HttpSession session = request.getSession(false);
        printWriter.println("<html>");
        printWriter.println("<head>");
        printWriter.println("<title>欢迎</title>");
        printWriter.println("</head>");
        printWriter.println("<body>");
        printWriter.println("<h1>目前在线人数" + LoginSessionListener.counter+" 人</h1>");
        if (Objects.nonNull(session)) {
            String user = (String) session.getAttribute("user");
            printWriter.println("<h1>欢迎:"+user+"</h1>");
        }
        printWriter.println("</body>");
        printWriter.println("</html>");
        printWriter.close();
    }
}
