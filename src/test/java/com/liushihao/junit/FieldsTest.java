package com.liushihao.junit;

import com.liushihao.entity.Album;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author 刘世豪
 * @description
 * @date 2021/1/26 16:11
 * @updateTime 2021/1/26 16:11
 */
public class FieldsTest {

    public static void getFields(Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = object.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            Field declaredField = declaredFields[i];
            String name = declaredField.getName();
            Class<?> type = declaredField.getType();
            System.out.println("name = " + name);
            System.out.println("type = " + type);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("get")
                    .append(Character.toUpperCase(name.charAt(0)))
                    .append(name.substring(1));
            Method method = aClass.getMethod(stringBuilder.toString());
            Object invoke = method.invoke(object);
            System.out.println("invoke = " + invoke);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Album album = new Album();
        album.setId("1");
        album.setAuthor("liush");
        album.setCount(7);
        getFields(album);
    }
}
