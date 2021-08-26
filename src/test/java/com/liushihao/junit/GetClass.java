package com.liushihao.junit;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Description
 * @Author 刘世豪
 * @Date 2021/8/20
 */
public class GetClass {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        String packageName = "com.liushihao.entity.%sReportDo";
        String[] classesNames = {"CIS40390", "CIS40391"};
        for (String classesName : classesNames) {
            Class aClass = getClass(String.format(packageName, classesName));
            System.out.println("aClass = " + aClass);
            String[] split = aClass.toString().split("\\.");
            System.out.println("className = " + split[split.length - 1]);
            Object instance = aClass.newInstance();
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                if ("requestReport".equals(method.getName())) {
                    Object invoke = method.invoke(instance);
                    System.out.println("invoke = " + invoke);
                }
            }
            System.out.println("=========================");
        }
    }

    public static Class getClass(String className) throws ClassNotFoundException {
        Class<?> obj = Class.forName(className);
        return obj;
    }
}
