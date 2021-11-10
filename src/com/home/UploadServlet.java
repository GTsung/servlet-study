package com.home;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author GTsung
 * @date 2021/2/21
 */
@WebServlet(urlPatterns = {"/upload"})
public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] body = readBody(request);
        String textBody = new String(body, StandardCharsets.ISO_8859_1);

    }

    private byte[] readBody(HttpServletRequest request) throws IOException {
        int formDataLength = request.getContentLength();
        DataInputStream dataInputStream = new DataInputStream(request.getInputStream());
        byte[] body = new byte[formDataLength];
        int totalBytes = 0;
//        while (totalBytes < formDataLength) {
//            int bytes = dataInputStream.read(body, totalBytes, formDataLength);
//            totalBytes+=bytes;
//        }

        dataInputStream.read(body, totalBytes, formDataLength);
        return body;
    }
}


class Position {

    int begin;
    int end;

    public Position(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }
}