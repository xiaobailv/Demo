package com.liushihao.junit;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    @Test
    public void traverseHashMap() {
        Map<Integer, String> hashMap = new HashMap<>();
        for (int i = 0; i < 20; i++) {
            hashMap.put(i, Integer.toString(i));
        }
        for (Map.Entry<Integer, String> integerStringEntry : hashMap.entrySet()) {
            System.out.println(integerStringEntry.getKey() + "======" + integerStringEntry.getValue());
        }
    }

    @Test
    public void loop() {
        Map<Integer, Integer> map = new HashMap<>();
//        map.put(1, 10);
//        map.put(2, 20);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    @Test
    public void nullTest() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put("1", "刘世豪");
        for (String s : hashMap.keySet()) {
            String s1 = hashMap.get(s);
            System.out.println("s = " + s);
            System.out.println("s1 = " + s1);
        }
    }

    @Test
    public void newHashMap() {
        Map<Object, Object> objectObjectMap = Collections.synchronizedMap(new HashMap<>());
        HashMap<String, String> hashMap = new HashMap<>(8);
        HashMap<String, String> hashMap1 = new HashMap<>();
        hashMap.put("1", "1");
        int n = 5;
        int i = n |= n;
        int j = n >>> 1;
        System.out.println(i);
        System.out.println(j);
        // ^ 异或运算 主要是对两个操作数进行位的异或运算, 相同取0, 相反取1. 即两个操作数相同时, 相互抵消.

        // |= 位或运算符 两个数都转为二进制，然后从高位开始比较，两个数只要有一个为1则为1，否则就为0。
        // &= 位于运算符 两个数都转为二进制，然后从高位开始比较，如果两个数都为1则为1，否则为0。
        // >> 表示右移，如果该数为正，则高位补0，若为负数，则高位补1；
        // >>> 表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0(无论正负都在高位补0)。
        // |= 和 >>> 的运算优先级, >>>先, |=后。
        n |= n >>> 1;
        System.out.println("n = " + n);
        n |= n >>> 2;
        System.out.println("n = " + n);
        n |= n >>> 4;
        System.out.println("n = " + n);
        n |= n >>> 8;
        System.out.println("n = " + n);
        n |= n >>> 16;
        System.out.println("n = " + n);
    }
}
