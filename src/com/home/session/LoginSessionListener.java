package com.home.session;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author GTsung
 * @date 2021/3/2
 */
@WebListener
public class LoginSessionListener implements HttpSessionListener {

    protected static int counter;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        LoginSessionListener.counter++; // 统计当前在线人数
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        LoginSessionListener.counter--;
    }
}
