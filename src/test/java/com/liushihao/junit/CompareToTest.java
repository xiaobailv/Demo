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
        BigDecimal num = new BigDecimal(0.001);
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
        System.out.println("以下为BigDecimal取反");
        System.out.println(fee2.divide(new BigDecimal(100.00)).negate());  // 0.01
        System.out.println(fee1.compareTo(BigDecimal.ZERO));
        System.out.println(BigDecimal.ZERO);
    }

    @Test
    public void bigDecimalString() {
        String str = "00000000000";
        BigDecimal bigDecimal = new BigDecimal(00000000000);
        System.out.println(new BigDecimal("1").multiply(bigDecimal.divide(new BigDecimal("100"))));
    }

    @Test
    public void zhengFu() {
        BigDecimal divide = new BigDecimal("00000000029").add(BigDecimal.ONE).divide(new BigDecimal("100.0"));
        BigDecimal multiply = BigDecimal.valueOf(-1).multiply(divide);
        System.out.println("multiply = " + multiply);
    }
}
