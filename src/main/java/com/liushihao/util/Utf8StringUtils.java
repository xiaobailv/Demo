package com.liushihao.util;

import java.nio.charset.Charset;

/**
 * Utf8StringUtils
 *
 * @author liush
 * @date 2021.0126
 */
public class Utf8StringUtils {

    public static String subString(String s, String postfix, int size) {
        // 1位
        final byte b1 = (byte) 0x80;
        // 2位
        final byte b2 = (byte) 0xC0;
        // 3位
        final byte b3 = (byte) 0xE0;
        // 4位
        final byte b4 = (byte) 0xF0;
        // 5位
        final byte b5 = (byte) 0xF8;

        if ((s == null) || (size <= 0)) {
            return "";
        }
        byte[] bytes = s.getBytes(Charset.forName("UTF-8"));
        int length = bytes.length;
        if (length <= size) {
            return s;
        } else {
            int endLen = postfix.getBytes(Charset.forName("UTF-8")).length;
            size -= endLen;
            if (size < 0) {
                return "";
            }
            int charwide = 1;
            int indexSt = size - 1;
            int indexEd = indexSt;
            while ((indexSt >= 0) && (indexEd >= 0)) {
                byte b = bytes[indexSt];
                if ((b & b1) == 0) {
                    // 当前字节为单字节字符
                    indexEd = indexSt;
                    break;
                } else if ((b & b2) == b1) {
                    // 当前字节为多字节字符的一部分
                    charwide++;
                } else if ((b & b3) == b2) {
                    // 当前字节为双字节字符的开头
                    if (charwide != 2) {
                        indexEd = indexSt - 1;
                    }
                    break;
                } else if ((b & b4) == b3) {
                    // 当前字节为三字节字符的开头
                    if (charwide != 3) {
                        indexEd = indexSt - 1;
                    }
                    break;
                } else if ((b & b5) == b4) {
                    if (charwide != 4) {
                        indexEd = indexSt - 1;
                    }
                    break;
                }
                indexSt--;
            }
            String utf8String = new String(bytes, 0, indexEd + 1, Charset.forName("UTF-8"));
            utf8String = utf8String.concat(postfix);
            return utf8String;
        }
    }

    public static String substring(String s, String postfix, int size) {
        byte[] bytes = s.getBytes(Charset.forName("UTF-8"));
        String result;
        if (bytes.length <= size) {
            return s;
        } else {
            byte[] postfixByte = postfix.getBytes(Charset.forName("UTF-8"));
            int end = size - postfixByte.length;
            if (bytes.length <= end) {
                result = new String(bytes, Charset.forName("UTF-8"));
            } else {
                byte[] byteResult = new byte[end];
                for (int i = 0; i < end; i++) {
                    byteResult[i] = bytes[i];
                }
                result = new String(byteResult, Charset.forName("UTF-8"));
                result += postfix;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        String str1 = "123(一二三abc)超过200个字符长度的字符串测试现在到多少个字符了有人知道吗我不知道现在是多少个了啊够了吗测试一下好像是不够继续在编一点吧现在应该差不多了吧要不再写一点算了";
        String string = Utf8StringUtils.subString(str1, "...", 120);
        System.out.println("string = " + string);
        String str2 = "123(一二三abc)超过200个字符长度的字符串测试现在到多少个字符了有人知道吗我不知道现在是多少个了啊够了吗测试一下好像是不够继续在编一点吧...";
        byte[] bytes = str2.getBytes(Charset.forName("UTF-8"));
        System.out.println(bytes.length);
        String substring = substring(str2, "...", 120);
        System.out.println("substring = " + substring);
    }
}
