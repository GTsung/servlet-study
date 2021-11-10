package com.home;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

/**
 * @author GTsung
 * @date 2021/2/23
 */
// location为文件保存的路径
@MultipartConfig(location = "C:\\Users\\xc_go\\Desktop\\kaoyao")
@WebServlet(urlPatterns = {"/upload2"})
public class PartUpload2Servet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // 处理中文文件名
        Part part = request.getPart("file"); // 获取文件
        String filename = getFilename(part);
        part.write(filename); // part.write(filename) 会将文件写到MultipartConfig注解配置的location处
    }

    private String getFilename(Part part) {
        String header = part.getHeader("Content-Disposition");
        return header.substring(header.indexOf("filename=\"") + 10, header.lastIndexOf("\""));
    }
}
