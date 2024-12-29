package com.liushihao.main.algorithm;

import java.util.HashSet;

/**
 * 位图的实现
 * | -> 或 -> 有一个是1就是1
 * & -> 与 -> 有一个是0就是0
 * ~ -> 取反
 *
 * @author 11092
 * @date 2024-12-29 13:39
 */
public class BitMap {

    private long[] bits;

    public BitMap(int max) {
        // (max + 64) >> 6 -> (max + 64) / 64
        bits = new long[(max + 64) >> 6];
    }

    public void add(int num) {
        // num >> 6 -> num / 64 -> 哪个整数
        // num & 63 -> num % 64 -> 第几个位置
        bits[num >> 6] |= 1L << (num & 63);
    }

    public void remove(int num) {
        bits[num >> 6] &= ~(1L << (num & 63));
    }

    public boolean contains(int num) {
        return (bits[num >> 6] & (1L << (num & 63))) != 0;
    }

    public static void main(String[] args) {
        System.out.println("测试开始！");
        int max = 10000;
        BitMap bitMap = new BitMap(max);
        HashSet<Integer> set = new HashSet<>();
        int testTime = 10000000;
        for (int i = 0; i < testTime; i++) {
            int num = (int) (Math.random() * (max + 1));
            double decide = Math.random();
            if (decide < 0.333) {
                bitMap.add(num);
                set.add(num);
            } else if (decide < 0.666) {
                bitMap.remove(num);
                set.remove(num);
            } else {
                if (bitMap.contains(num) != set.contains(num)) {
                    System.out.println("Oops!");
                    break;
                }
            }
        }
        for (int num = 0; num <= max; num++) {
            if (bitMap.contains(num) != set.contains(num)) {
                System.out.println("Oops!");
            }
        }
        System.out.println("测试结束！");
    }
}
