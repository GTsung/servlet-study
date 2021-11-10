package com.home.chat;

import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author GTsung
 * @date 2021/2/25
 */
@WebServlet(urlPatterns = "/login2")
public class LoginServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        System.out.println(username);
        System.out.println(session.getId());
//        session.invalidate(); // 销毁session
        session.setMaxInactiveInterval(10 * 60); // 用户持续10分钟不活动则HttpSession对象失效

        // 获取sessionCookieConfig
        SessionCookieConfig sessionCookieConfig = request.getServletContext().getSessionCookieConfig();
        // sessionCookieConfig对name及age的改变应该在servletContext对象初始化前才会成功，因此只能在web.xml中配置
        System.out.println(sessionCookieConfig.getName()); // 获取web.xml中配置的

    }
}
