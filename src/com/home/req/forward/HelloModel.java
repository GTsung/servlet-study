package com.home.req.forward;

import java.util.HashMap;
import java.util.Map;

/**
 * @author GTsung
 * @date 2021/2/23
 */
public class HelloModel {
    private static final Map<String, String> MAP = new HashMap<>();

    public HelloModel() {
        MAP.put("Jhon", "hi");
        MAP.put("Jonny", "radiohead");
    }

    public String getMsg(String user) {
        return MAP.get(user) + user;
    }
}
