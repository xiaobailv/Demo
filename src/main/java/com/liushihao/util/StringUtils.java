package com.liushihao.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

@Slf4j
public class StringUtils {

    /**
     * 将字符串按照字节长度进行截取
     * @param str 需要截取的字符串
     * @param begin 截取开始的下标
     * @param length 需要截取的长度
     * @return 截取到的字符串
     */
    public static String subStringByBytes(String str, int begin, int length, String charset) {
        String newStr = "";
        try {
            // 按指定的编码获取字节数组
            byte[] bytes = str.getBytes(charset);
            // 按指定的长度截取新的字符数组
            byte[] newBytes = Arrays.copyOfRange(bytes, begin, begin + length);
            // 将新的字符数组转化为字符串
            newStr = new String(newBytes, charset);
        } catch (UnsupportedEncodingException e) {
            log.info("——————字符转码异常——————");
        }
        return newStr;
    }

    public static String subStringByBytes(String str, int begin, int length) {
        String newStr = "";
        try {
            // 按指定的编码获取字节数组
            byte[] bytes = str.getBytes("GBK");
            // 按指定的长度截取新的字符数组
            byte[] newBytes = Arrays.copyOfRange(bytes, begin, begin + length);
            // 将新的字符数组转化为字符串
            newStr = new String(newBytes, "GBK");
        } catch (UnsupportedEncodingException e) {
            log.info("——————字符转码异常——————");
        }
        return newStr;
    }
}
