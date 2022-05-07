package com.liushihao.junit.train;

/**
 * @Description
 * @Author 刘世豪
 * @Date 2021/9/15
 */
public class Test {

    static boolean foo(char c) {
        System.out.println(c);
        return true;
    }

    public static void main(String[] args) {
        int i = 0;
        for (foo('A'); foo('B') && (i < 2); foo('C')) {
            i++;
            foo('D');
        }

        String a = "";
        System.out.println(a.equals("111"));
    }
}
