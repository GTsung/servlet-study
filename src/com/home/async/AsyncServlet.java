package com.home.async;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author GTsung
 * @date 2021/3/7
 */
//<servlet>
//<servlet-name>AsyncServlet</servlet-name>
//<servlet-class>com.home.async.AsyncServlet</servlet-class>
//<async-supported>true</async-supported>
//</servlet>
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    private ExecutorService executorService = Executors.newFixedThreadPool(10);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF8");
        AsyncContext asyncContext = request.startAsync();
        executorService.submit(new AsyncRequest(asyncContext));
    }

    @Override
    public void destroy() {
        executorService.shutdown();
    }
}
