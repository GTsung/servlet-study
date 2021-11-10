package com.home;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

/**
 * @author GTsung
 * @date 2021/2/22
 */
@MultipartConfig // 必须使用此注解才能通过getPart获取文件
@WebServlet(urlPatterns = {"/part"})
public class PartUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("photo");
        String header = part.getHeader("Content-Disposition");
        String filename = header.substring(header.indexOf("filename=\"") + 10,
                header.lastIndexOf("\""));

        // 输出到磁盘
        InputStream in = request.getInputStream();
        OutputStream out = new FileOutputStream("/kk/" + filename);
        byte[] buffer = new byte[1024];
        int length = -1;
        while((length = in.read(buffer)) != -1) {
            out.write(buffer, 0 ,length);
        }
        in.close();
        out.close();
    }
}
