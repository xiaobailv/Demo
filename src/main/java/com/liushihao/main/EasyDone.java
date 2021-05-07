package com.liushihao.main;

import java.util.Locale;

/**
 * @author 刘世豪
 */
public class EasyDone {

    public String sayHello() {
        Locale local = Locale.getDefault();
        if (local.equals(Locale.CHINA)) {
            // 在中国, 就说中文
            return "你好，世界。";
        } else {
            // 在其他国家，就说英文
            return "Hello World.";
        }
    }

     private String sayHey() {
        Locale local = Locale.getDefault();
        if (local.equals(Locale.CHINA)) {
            // 在中国, 就说中文
            return "你好，世界。";
        } else {
            // 在其他国家，就说英文
            return "Hello World.";
        }
    }
}
