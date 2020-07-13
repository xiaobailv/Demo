package com.liushihao.junit;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class mainTest {

    public static void main(String[] args) {
        /*System.out.println(booleanTest());*/
        try {
            System.out.println(fileClose());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*private static Boolean booleanTest() {
        Integer a = 10;
        return a == 2;
    }*/

    private static String fileClose() throws IOException {
        // 读文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\KL-Bank\\INFB-INFR\\INF20032801B"), StandardCharsets.UTF_8));
        // 将读取到的字符串赋值给line
        String line = br.readLine();
        if (line != null) { // 如果读取到的不为null则说明文件有内容
            br.close();
            return line;
        } else {
            System.out.println("文件没有内容");
        }
        br.close();
        System.out.println("结束T0206读取success文件...");
        return null;
    }
}
