package com.home.async;

import javax.servlet.AsyncContext;
import java.io.PrintWriter;

/**
 * @author GTsung
 * @date 2021/3/7
 */
public class AsyncRequest implements Runnable {

    private AsyncContext asyncContext;

    public AsyncRequest(AsyncContext asyncContext) {
        this.asyncContext = asyncContext;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            PrintWriter writer = asyncContext.getResponse().getWriter();
            writer.println("久等了。。。xd");
            // 执行完毕
            asyncContext.complete();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
