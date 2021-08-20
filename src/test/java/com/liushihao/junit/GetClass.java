package com.liushihao.junit;

/**
 * @Description
 * @Author 刘世豪
 * @Date 2021/8/20
 */
public class GetClass {

    public static void main(String[] args) {

    }

    public static Class getClass(String className) throws ClassNotFoundException {
        Class<?> obj = Class.forName(className);
        return obj;
    }
}
