package com.home;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author GTsung
 * @date 2021/2/21
 */
@WebServlet(urlPatterns = {"/third"})
public class ThirdServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String charset = request.getCharacterEncoding();
        System.out.println(charset);

        request.setCharacterEncoding("UTF-8");

        /**
         * POST请求方式获取参数
         * A. 在postman中使用x-www-form-urlencoded发送
         * B. 使用raw，设置编码为JSON(application/json)
         */

        // postMan使用A方式
        String name = request.getParameter("name");
        System.out.println(name);

        // postMan使用B方式
        ServletInputStream inputStream = request.getInputStream(); // 读取body，是一个输入流
        byte[] bytes = new byte[102400];
        inputStream.read(bytes);
        String body = new String(bytes);
        System.out.println(body); // {"name":"鎴戞搷"}    乱码
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get请求方式，使用request.setCharacterEncoding("UTF-8");不再起作用，因为处理URL的是HTTP服务器而非web容器
        // url: http://localhost:9000/servlet_demo/third?name=%E6%88%91%E6%92%92%E6%97%A6
        String name = request.getParameter("name");
        System.out.println(name);
        name = new String(name.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8); // 处理编码方式
        System.out.println(name);
    }
}
