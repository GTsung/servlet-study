package com.home.req.listen;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;

/**
 * @author GTsung
 * @date 2021/3/6
 */
@WebListener
public class AttributeListener implements ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletRequestAttributeEvent event) {
        ServletRequest request = event.getServletRequest();
        String filedName = event.getName();
        String fieldValue = (String) event.getValue();
        System.out.println(filedName + "--" + fieldValue);
    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent event) {
        ServletRequest request = event.getServletRequest();
        String filedName = event.getName();
        String fieldValue = (String) event.getValue();
        System.out.println(filedName + "--" + fieldValue);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent event) {
        ServletRequest request = event.getServletRequest();
        String filedName = event.getName();
        String fieldValue = (String) event.getValue();
        System.out.println(filedName + "--" + fieldValue);
    }
}
