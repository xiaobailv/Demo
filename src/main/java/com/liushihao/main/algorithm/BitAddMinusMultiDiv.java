package com.liushihao.main.algorithm;

/**
 * // 测试链接：https://leetcode.com/problems/divide-two-integers
 * @author 11092
 * @date 2024-12-29 13:50
 */
public class BitAddMinusMultiDiv {

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            // a ^ b -> 无进位相加信息
            sum = a ^ b;
            // (a & b) << 1 -> 进位信息 -> b -> b`(进位信息)
            b = (a & b) << 1;
            // a -> a` 无进位相加信息
            a = sum;
        }
        return sum;
    }

    /**
     * n取反 -> ~n + 1 -> add(~n, 1)
     */
    public static int negNum(int n) {
        return add(~n, 1);
    }

    /**
     * a - b ->
     * a + (-b) ->
     * a + (~b + 1)
     * a + add(~b, 1)
     */
    public static int minus(int a, int b) {
        return add(a, negNum(b));
//        return add(a, add(~b, 1));
    }

    public static int mulit(int a, int b) {
        int ans = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                ans = add(ans, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return ans;
    }
}
