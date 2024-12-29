package com.liushihao.main.algorithm;

/**
 * @author 11092
 * @Description
 * @create 2024-12-21 8:50
 */
public class Print {

    private static void print(int num) {
        for (int i = 31; i >= 0; i--) {
            System.out.print((num & (1 << i)) == 0 ? "0" : "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(1);
        print(Integer.MIN_VALUE);
    }
}
