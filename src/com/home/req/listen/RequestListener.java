package com.home.req.listen;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * @author GTsung
 * @date 2021/3/3
 */
@WebListener
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("执行结束");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("执行开始");
    }
}
