package com.home.filt.res;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

/**
 * @author GTsung
 * @date 2021/3/6
 */
public class CompressionWrapper extends HttpServletResponseWrapper {

    private GZipServletOutputStream gZipServletOutputStream;
    private PrintWriter printWriter;

    public  CompressionWrapper(HttpServletResponse response) {
        super(response);
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        if (gZipServletOutputStream != null) { // 调用一次
            throw new IllegalStateException();
        }
        if (null == printWriter) {
            gZipServletOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
            OutputStreamWriter osw = new OutputStreamWriter(gZipServletOutputStream, getResponse().getCharacterEncoding());
            printWriter = new PrintWriter(osw);
        }
        return printWriter;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        if (printWriter != null) {
            throw new IllegalStateException();
        }
        if (gZipServletOutputStream == null) {
            gZipServletOutputStream = new GZipServletOutputStream(getResponse().getOutputStream());
        }
        return gZipServletOutputStream;
    }

    public GZIPOutputStream getGZipOutputStream() {
        if (this.gZipServletOutputStream == null) {
            return null;
        }
        return this.gZipServletOutputStream.getGzipOutputStream();
    }
}
