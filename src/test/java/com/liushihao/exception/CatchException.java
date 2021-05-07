package com.liushihao.exception;

public class CatchException {

    public static void throwException1() {
        RuntimeException aaa = new RuntimeException("aaa");
        throw new RuntimeException("111", aaa);
    }

    public static void throwException2() {
        RuntimeException bbb = new RuntimeException("bbb");
        throw new RuntimeException("222", bbb);
    }

    public static void main(String[] args) {
        String str1 = "111";
        try {
            if (str1.equals("111")) {
                throwException1();
            } else {
                throwException2();
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
