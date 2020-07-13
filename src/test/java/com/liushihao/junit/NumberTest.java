package com.liushihao.junit;

import org.junit.Test;

import java.math.BigDecimal;

public class NumberTest {

    @Test
    public void integerToShort() {
        Integer integer = 100123;
        System.out.println(integer.shortValue());
    }

    @Test
    public void integerToLong() {
        Integer integer = 123456;
        System.out.println(Long.parseLong(integer.toString()));
    }

    @Test
    public void integerAndDouble() {
//        Integer i = 6;
//        Integer j = 5;
        BigDecimal bigDecimal = new BigDecimal(64).divide(new BigDecimal(10));       // 6.4
        BigDecimal multiply = bigDecimal.add(new BigDecimal(0.5001));   // 6.9001
        System.out.println("bigDecimal = " + bigDecimal);
        System.out.println("multiply = " + multiply);
        int i = multiply.intValue();
        System.out.println("i = " + i);
    }
}
