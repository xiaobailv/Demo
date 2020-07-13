package com.liushihao.junit;

import com.liushihao.entity.Log;
import com.liushihao.entity.User;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class StringTest {

    private Integer integer = null;

    @Test
    public void integerInit() {
        System.out.println(integer);
    }

    @Test
    public void stringFormat() {
        String str = "01234567890";
        System.out.println(String.format("%-19s", str));                    // "0123456789         "后面补齐空格
        System.out.println(String.format("%012d", Integer.valueOf(str)));   // 000123456789 前面补零
        System.out.println(String.format("%012d", 1));                      // 000000000001 前面补零
        System.out.println(String.format("%3s", "1"));                      // "  1"    前面补空格
    }

    @Test
    public void stringSubstring() {
        String str = "09F3712345678901";
        System.out.println(str.indexOf("9F37"));
        System.out.println(str.length() + " | " + str.substring(0, 3));
        System.out.println(str.substring(8, 9));
        System.out.println(str.substring(8, 9));
        System.out.println(str.substring(1));
    }

    @Test
    public void springSplit() {
        String str = "a, b, c, ,d";
        String[] split = str.split(",");
        String substring = str.substring(str.lastIndexOf(",") + 1);
        System.out.println("split.length = " + split.length);   // split.length = 4
        System.out.println("substring = " + substring);
    }

    @Test
    public void stringArray() {
        String[] strings = new String[]{"0123456789", "9876543210"};
        String string1 = strings[0];
        String string2 = strings[1];
        System.out.println("string1 = " + string1);
        System.out.println("string2 = " + string2);
    }

    @Test
    public void readFileChinese() throws IOException {
        String filePath = "D:\\IDEAWorkspace\\demo\\serilizable\\测试中文.txt";
        FileInputStream fis = new FileInputStream(filePath);
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(isr);
        // 简写 BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8));
        String line;
        while ((line = br.readLine()) != null) {
//            System.out.println(line);
            System.out.println(line.substring(1, 4));
        }
    }

    @Test
    public void space() {
        Log log = new Log();
        System.out.println(String.format("%12s", log.getId()));
        System.out.println(String.format("%010d", 2));
        System.out.println(String.format("%-11s", "05478888"));
    }

    @Test
    public void replaceString() {
        String str = "/home/gbatch/recon/file/YYYYMMDD/100093/RZ";
        String str1 = "JLYYMMDD02MSUM.OK";
        if (str1.contains(".OK")) {
            System.out.println("OK");
        }
        System.out.println(str.replace("YYYYMMDD", "12345678"));
        System.out.println(str1.replace("YYMMDD", "123456"));
    }

    @Test
    public void stringEquals() {
        User user = new User("2", null, null, null, null, null, null);

        if ("1".equals(user.getId())) {
            System.out.println("user.getId() equals " + user.getId());
        } else {
            System.out.println("user.getId()111 equals " + user.getId());
        }

        if (user.getId() == "1") {
            System.out.println("user == " + user.getId());
        } else {
            System.out.println("user.getId()111 == " + user.getId());
        }

        String a = "1" + 2;     // 111
        String b = "12";        // 111
        String c = new String("12");
        System.out.println(c == b);         // fasle
        System.out.println(c.equals(b));    // true
    }
}
