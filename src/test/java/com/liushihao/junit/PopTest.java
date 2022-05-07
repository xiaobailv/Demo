package com.liushihao.junit;

public class PopTest {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.out.println("MAXIMUM_CAPACITY = " + MAXIMUM_CAPACITY);

        System.out.println(tableSizeFor(8));
    }

    public static int tableSizeFor(int cap) {
        int n = -1 >>> Integer.numberOfLeadingZeros(cap - 1);
        System.out.println("n = " + n);
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }
}
