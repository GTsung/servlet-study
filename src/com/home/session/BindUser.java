package com.home.session;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * @author GTsung
 * @date 2021/3/3
 */
public class BindUser implements HttpSessionBindingListener {

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        // 当session.setAttribute(new BindUser())时执行此方法
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {

    }
}
