package com.liushihao.junit;

import com.liushihao.util.TLVData;
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

    @Test
    public void integerParse() {
        String str = "9F26087BC11937E0B9604A9F2701409F101307011703900000010A01000000000054B7A69F9F3704486904DD9F360200A7950500000000009A032004039C01009F02060000000016005F2A02015682027C009F1A0201569F03060000000000009F3303E0E1C89F1E0831333731353338308408A0000003330101029F090200209F4104000040619F34033F00009F3501229F74064543433030318A025931  ";//"9F26087BC11937E0B9604A9F2701409F101307011703900000010A01000000000054B7A69F9F3704486904DD9F360200A7950500000000009A032004039C01009F02060000000016005F2A02015682027C009F1A0201569F03060000000000009F3303E0E1C89F1E0831333731353338308408A0000003330101029F090200209F4104000040619F34033F00009F3501229F74064543433030318A025931                                                                                                                                                                                                  88202100774450000018               成吉思汗                                                    0";
        TLVData.getTagValue(str, "9F33");
        String firstByte = str.substring(0, 2);
        int i = Integer.parseInt(firstByte, 16);
        if ((i & 0x1f) == 0x1f) {
            str.substring(0, 4);

        }
    }

    @Test
    public void bigDecimal() {
        BigDecimal bigDecimal1 = new BigDecimal("100");
        BigDecimal bigDecimal2 = new BigDecimal("7");
        BigDecimal divide = bigDecimal1.divide(bigDecimal2, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("divide = " + divide);

        BigDecimal divide1 = new BigDecimal("0.213").divide(new BigDecimal("100"), 5, BigDecimal.ROUND_HALF_UP);
        System.out.println("divide1 = " + divide1);

//        System.out.println(new BigDecimal(""));

        String string = new BigDecimal("00000001025012").toString();
        String string1 = new BigDecimal("0001025012").toString();
        System.out.println("string = " + string);
        System.out.println("string1 = " + string1);
        int i = Integer.parseInt(string);
        int i1 = Integer.parseInt(string1);
        System.out.println(i);
        System.out.println(i1);

        System.out.println(i == i1);
    }

    @Test
    public void mathMin() {
        int min = Math.min((5 + 1) * 2000, 10627);
        System.out.println("min = " + min);
    }
}
