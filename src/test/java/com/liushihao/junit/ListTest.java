package com.liushihao.junit;

import cn.hutool.core.collection.CollectionUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {

    @Test
    public void loopArray() {
        List<String> list = new ArrayList<>(2);
        list.add("刘");
        list.add("世");
        list.add("豪");
        String[] array = new String[list.size()];
        array = list.toArray(array);
        for (String s : array) {
            System.out.println("s = " + s);
        }
    }

    @Test
    public void list() {
        List<String> list = new ArrayList<>();
        String str1 = null;
        String str2 = null;
        list.add(str1);
        list.add(str2);
        System.out.println(list.size());        // 2
        for (String s : list) {
            System.out.println("s = " + s);     // null
        }
    }

    @Test
    public void ListForeach() {
        // 存放数据
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i + "");
        }
        // 遍历删除list中值为listDelete集合中的数据
        List<String> listDelete = new ArrayList<>();
        listDelete.add("5");
        listDelete.add("9");
        listDelete.add("3");
        listDelete.add("7");
        listDelete.add("2");
        /*for (int variable1 = 0; variable1 < list.size(); variable1++) {
            String s = list.get(variable1);
            for (String s1 : listDelete) {
                if (s1.equals(s)) {
                    list.remove(variable1);
                }
            }
        }*/
        if (list.size() != 0) {
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String next = iterator.next();
                for (String s : listDelete) {
                    if (next.equals(s)) {
                        iterator.remove();
                    }
                }
            }
            // 遍历删除过数据的集合
            for (String s : list) {
                System.out.println(s);
            }
        }
    }

    @Test
    public void loop() {
        ArrayList<String> list = new ArrayList<>();
        if (CollectionUtil.isEmpty(list)) {
            System.out.println("空");
            for (String s : list) {
                System.out.println("s = " + s);
            }
        } else {
            System.out.println("非空");
            for (String s : list) {
                System.out.println("s = " + s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        System.out.println("第一个" + list.get(0));
        list.forEach(i -> {
            System.out.println("i = " + i);
        });
        /*for (int i = 1; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
        System.out.println("=======");
        for (int i = 1; i < 1; i++) {
            System.out.println(list.get(i));
        }
//        System.out.println("stringBuilder = " + stringBuilder);
    }

    @Test
    public void contains() {
        List<String> list = new ArrayList<>(3);
        list.add("刘");
        list.add("世");
        list.add("豪");
        System.out.println(list.contains("刘"));
        System.out.println(list.contains("六"));
    }
}
