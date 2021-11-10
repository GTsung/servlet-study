package com.home.session;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * @author GTsung
 * @date 2021/3/3
 */
public class BindUser2 implements HttpSessionActivationListener {

    @Override
    public void sessionWillPassivate(HttpSessionEvent se) {
        // 分布式环境中，HttpSession从一个JVM迁到另一个JVM时，会将session中的所有
        // 属性对象都序列化，如果属性对象实现了HttpSessionActivationListener
        // 就会执行此方法
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent se) {
        // HttpSession迁移到另一个JVM后会对所有属性对象进行反序列化，此时执行此方法
    }
}
