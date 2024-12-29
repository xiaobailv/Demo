package com.liushihao.main.algorithm;

/**
 * @author 11092
 * @Description 计算 n!
 * @create 2024-12-21 15:32
 */
public class SumOfFactorial {

    public static long f1(int n) {
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += factorial(n);
        }
        return ans;
    }

    public static long factorial(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static long f2(int n) {
        long cur = 1;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            cur = cur * i;
            ans += cur;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(f2(3));
    }
}
