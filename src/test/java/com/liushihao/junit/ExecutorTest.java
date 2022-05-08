package com.liushihao.junit;


public class ExecutorTest {

    public static void main(String[] args) {
//        new ThreadPoolExecutor(5, 5, 20L, )
        ThreadLocal threadLocal = new ThreadLocal();
        System.out.println(threadLocal.get());
    }
}
