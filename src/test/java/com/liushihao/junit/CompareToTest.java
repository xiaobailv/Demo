package com.liushihao.junit;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/23 8:50
 */

public class CompareToTest {

    @Test
    public void compareTo() {
        BigDecimal fee1 = new BigDecimal(1);
        BigDecimal fee2 = new BigDecimal(-1);
        BigDecimal fee3 = new BigDecimal(0.001);
        BigDecimal fee4 = new BigDecimal("0");
        BigDecimal num = new BigDecimal(0.001);
        System.out.println("以下为BigDecimal取反");
        System.out.println(fee1.divide(new BigDecimal(100.00)).negate());
        System.out.println(fee2.divide(new BigDecimal(100.00)).negate());
        System.out.println(fee1.compareTo(new BigDecimal(0.001)));
        System.out.println(fee2.compareTo(new BigDecimal(0.001)));
        System.out.println(fee3.compareTo(new BigDecimal(0.001)));
        System.out.println("=========");
        if (fee1.compareTo(num) == 1) {
            System.out.println(fee1.compareTo(new BigDecimal(0.001)));
            System.out.println("大于");
            System.out.println("-----------");
        }
        if (fee2.compareTo(num) == -1) {
            System.out.println(fee2.compareTo(new BigDecimal(0.001)));
            System.out.println("小于");
            System.out.println("-----------");
        }
        if (fee3.compareTo(num) == 0) {
            System.out.println(fee3.compareTo(new BigDecimal(0.001)));
            System.out.println("等于");
            System.out.println("-----------");
        }
        System.out.println("=========");
        String a = "0";
        String b = "10";
        String count = "5";
        System.out.println(a.compareTo(count));
        System.out.println(b.compareTo(count));
        System.out.println("5".compareTo(count));
        System.out.println("=========");
        System.out.println(fee2.subtract(fee1).abs());
        System.out.println(fee1.compareTo(BigDecimal.ZERO));
        System.out.println(BigDecimal.ZERO);

        // fee1 = 1, fee2 = -1, fee4 = 0
        int i = fee1.compareTo(BigDecimal.ZERO);
        int i1 = fee2.compareTo(BigDecimal.ZERO);
        int i2 = fee4.compareTo(BigDecimal.ZERO);
        System.out.println("i = " + i);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);
    }

    @Test
    public void bigDecimalString() {
        String str = "00000000000";
        BigDecimal bigDecimal = new BigDecimal(00000000000);
        System.out.println("bigDecimal = " + bigDecimal);
        String str1 = "10.22";
        String str2 = "10.25";
        String str3 = "10.28";
        String str4 = "10";
        BigDecimal bigDecimal1 = BigDecimal.valueOf(Double.parseDouble(str1));
        BigDecimal bigDecimal2 = BigDecimal.valueOf(Double.parseDouble(str2));
        BigDecimal bigDecimal3 = BigDecimal.valueOf(Double.parseDouble(str3));
        BigDecimal bigDecimal4 = BigDecimal.valueOf(Double.parseDouble(str4));
        System.out.println("bigDecimal1 = " + bigDecimal1);
        System.out.println("bigDecimal2 = " + bigDecimal2);
        System.out.println("bigDecimal3 = " + bigDecimal3);
        System.out.println("bigDecimal4 = " + bigDecimal4);
        System.out.println("###########################");
        int compareTo = bigDecimal4.compareTo(BigDecimal.TEN);
        System.out.println("compareTo = " + compareTo);
        System.out.println("###########################");
        Integer integer1 = 10;
        Integer integer2 = 10;
        System.out.println(integer1 == integer2);
        System.out.println(integer1.equals(integer2));
        System.out.println(new BigDecimal("1").multiply(bigDecimal.divide(new BigDecimal("100"))));
    }

    @Test
    public void zhengFu() {
        BigDecimal divide = new BigDecimal("00000000029").add(BigDecimal.ONE).divide(new BigDecimal("100.0"));
        BigDecimal multiply = BigDecimal.valueOf(-1).multiply(divide);
        System.out.println("multiply = " + multiply);
    }

    @Test
    public void negate() {
        BigDecimal bigDecimal = new BigDecimal("-10.302");
        BigDecimal bigDecimal2 = new BigDecimal("0");
        BigDecimal negate = bigDecimal.negate();
        BigDecimal negate2 = bigDecimal2.negate();
        System.out.println("negate = " + negate);
        System.out.println("negate2 = " + negate2);
    }
}
