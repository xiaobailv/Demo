package com.liushihao.junit;

public class ThreadTest {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {

        });
    }
}

class Foo extends Thread {

    public void run () {

    }
}
