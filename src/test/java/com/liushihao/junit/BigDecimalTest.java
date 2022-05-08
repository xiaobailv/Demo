package com.liushihao.junit;

import com.liushihao.entity.Jd;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Objects;

public class BigDecimalTest {

    @Test
    public void negate() {
        System.out.println(BigDecimal.ZERO.negate());
        System.out.println(BigDecimal.ONE.negate());
        System.out.println(BigDecimal.TEN.negate());
        Integer i = 0;
//        i = -i;
        i = Integer.reverse(i);
        System.out.println("i = " + i);
    }

    @Test
    public void test1() {
        String str1 = "1111";
        String str11 = "111";
        BigDecimal str2 = BigDecimal.valueOf(20.0);
        BigDecimal str22 = BigDecimal.valueOf(20.500);
        Integer str3 = 333;
        Integer str33 = null;
        String str4 = "4441";
        String str44 = "444";

        if (str2.equals(str22)) {
            System.out.println("20.55");
        }
//        if (str1.equals("111")
//                || str2.equals("222")
//                || str3.equals("333")
//                || str4.equals("444")) {
//            System.out.println("报错");
//        }
        if ((str1 != null && !str1.equals("111"))
                || (str2 != null && !str2.equals("222"))
                || (str3 != null && !str3.equals("333"))
                || (str4 != null && !str4.equals("444"))) {
            System.out.println("1 - 报错");
        } else {
            System.out.println("1 - 不报错");
        }
//        Boolean b = str1 != null ? !str1.equals(str11) : (str11 != null ? !str11.equals(str1) : false);
//        System.out.println("b = " + b);
        if ((str1 != null ? !str1.equals(str11) : (str11 != null && !str11.equals(str1)))
                || (str2 != null ? str2.compareTo(str22) != 0 : (str22 != null && str22.compareTo(str2) != 0))
                || (str3 != null ? !str3.equals(str33) : (str33 != null && !str33.equals(str3)))
                || (str4 != null ? !str4.equals(str44) : (str44 != null && !str44.equals(str4)))) {
            System.out.println("2 - 报错");
        } else {
            System.out.println("2 - 不报错");
        }

        if (str1 != null ? !str1.equals(str11) : (str11 != null ? !str11.equals(str1) : false)) {
            System.out.println("111");
        }
        if (!Objects.equals(str3, str33)) {
            System.out.println("报错");
        }
    }

    @Test
    public void add() {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(1);
        boolean equals = Objects.equals(i1, i2);
        System.out.println("equals = " + equals);


        String s1 = "1";
        String s2 = null;
        boolean equals1 = Objects.equals(s1, s2);
        System.out.println("equals1 = " + equals1);

        BigDecimal b1 = BigDecimal.ONE;
        BigDecimal b2 = BigDecimal.ZERO;
        int i = b1.compareTo(b2);
        System.out.println("i = " + i);

//        if (s1.equals("1")) {
//            return;
//        }

        switch (s1) {
            case "1":
                System.out.println("1");
                break;
            case "2":
                System.out.println("2");
                break;
        }

        Boolean aBoolean = comBigDecimal(BigDecimal.ZERO, BigDecimal.ONE);
        if (aBoolean) {
            System.out.println("不一致");
        } else {
            System.out.println("一致");
        }
        Jd jd = new Jd();
        jd.setId("1");
        Jd jd1 = new Jd();
        jd1.setId("1");
        String id = jd.getId();
        String id1 = jd1.getId();
        boolean equals2 = Objects.equals(id, id1);
        System.out.println("equals2 = " + equals2);

        String ss1 = "123";
        String s = new String("123");
        boolean b = ss1 == s;
        System.out.println("b = " + b);
        boolean equals3 = Objects.equals(ss1, s);
        System.out.println("equals3 = " + equals3);
    }

    public Boolean comBigDecimal(BigDecimal b1, BigDecimal b2) {
        if (b1 != null & b2 != null) {
            return b1.compareTo(b2) != 0;
        } else if (b1 != null) {
            return true;
        } else return b2 != null;
    }
}
