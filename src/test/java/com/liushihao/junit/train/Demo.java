package com.liushihao.junit.train;

/**
 * @Description
 * @Author 刘世豪
 * @Date 2021/9/15
 */
public class Demo {
    public static void main(String[] args) {
        int num = 10;
        System.out.println(test(num));
    }

    public static int test(int b) {
        try {
            b += 10;
            return b += 10;
        } catch (RuntimeException e) {

        } catch (Exception e2) {

        } finally {
            b += 10;
            return b;
        }
    }
}
