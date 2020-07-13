package com.liushihao.junit;

import org.junit.Test;

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
        map.put(1, 10);
        map.put(2, 20);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
