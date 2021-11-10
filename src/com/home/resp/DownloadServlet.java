package com.home.resp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author GTsung
 * @date 2021/2/24
 */
@WebServlet(urlPatterns = {"/download"})
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");
        if ("123456".equals(password)) {
            response.setContentType("application/pdf");
            // 获取WEB应用程序，从而获取pdf
            InputStream in = getServletContext().getResourceAsStream("/WEB-INF/shellbook.pdf");
            // 获取输出流，将文件输出
            OutputStream outputStream = response.getOutputStream();
            writePdf(in, outputStream);
        }
    }

    private void writePdf(InputStream in, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int length = -1;
        while ((length = in.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        in.close();
        outputStream.close();
    }
}
