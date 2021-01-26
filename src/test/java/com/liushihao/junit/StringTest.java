package com.liushihao.junit;

import com.liushihao.entity.Log;
import com.liushihao.entity.User;
import com.liushihao.util.WriteUtil;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.lang.Integer.parseInt;
import static java.nio.charset.StandardCharsets.UTF_8;

@Slf4j
// @SpringBootTest
// @RunWith(SpringRunner.class)
public class StringTest {

    @Autowired
    private StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String encrypt = stringEncryptor.encrypt("123"); // ZexzBz529SG4GlfEYSrrAw==
        System.out.println("================");
        System.out.println(encrypt);
        System.out.println("================");
    }

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
        System.out.println("str.substring(0) = " + str.substring(0));
        System.out.println("str.substring(1) = " + "X" + str.substring(1));
        if (str.endsWith("01")) {
            System.out.println("成功");
        }
        String str2 = "000000001000";
        System.out.println(parseInt(str2, 10));
        String amtTrans = String.valueOf(Integer.valueOf(str2));
        System.out.println("amtTrans = " + amtTrans);
        System.out.println(str.indexOf("9F37"));
        System.out.println(str.length() + " | " + str.substring(0, 3));
        System.out.println(str.substring(8, 9));
        System.out.println(str.substring(8, 9));
        System.out.println(str.substring(1));

        System.out.println("--------------");

        String str3 = "2020-10-23 17:58:36";
        System.out.println(str3.substring(0, 10).replace("-", ""));
        System.out.println(str3.substring(11));

        String str4 = "0.00|0.200%|2018060860301976";
        String[] split = str4.split("\\|");
        System.out.println("split[0] = " + split[0]);
        System.out.println("split[1] = " + new BigDecimal(split[1].replace("%", "")).divide(new BigDecimal("100"), 5, RoundingMode.HALF_UP));
        System.out.println("split[2] = " + split[2]);

        String str5 = "20201023";
        System.out.println(str5.substring(0, 4));
        System.out.println(str5.substring(4, 6));
        System.out.println(str5.substring(6, 8));

        System.out.println("----------------");
        String str6 = "123.xlsx";
        String str7 = ".123xlsx";
        String str8 = "123xlsx";
        System.out.println(str6.indexOf("."));
        System.out.println(str7.indexOf("."));
        System.out.println(str8.indexOf("."));
        System.out.println(str6.substring(str6.lastIndexOf(".")));
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
        System.out.println("string1 = " + strings[0]);
        System.out.println("string2 = " + strings[1]);
        strings[0] = "string1";
        strings[1] = "string2";
        System.out.println("string1 = " + strings[0]);
        System.out.println("string2 = " + strings[1]);
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
        String str2 = "1~|~2~|~3~|~4~|~5~|~";
        String[] split = str2.split("~\\|~");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            System.out.println("s = " + s);
        }
        System.out.println("-----------------");
        List<String> list = new ArrayList<>();
        list.add("刷卡手续费机构支出文件1");
        list.add("刷卡手续费机构支出文件2");
        list.add("刷卡手续费机构收入文件2");
        list.add("刷卡手续费机构收入文件1");
        int i = 0;
        for (String s : list) {
            i++;
            if (s.contains("收入")) {
                System.out.println("收入" + i);
            } else {
                System.out.println("支出" + i);
            }
        }
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

    @Test
    public void readeFileGbk() throws IOException {
        WriteUtil.write("D:/Download/aaa.txt", "测试刘世豪", false);
        //设置reader需要的Resource
        String filePath = "D:\\KL-Bank\\INFB-INFR\\INF20032801B";
        filePath = "D:/Download/aaa.txt";
        // 读文件
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), "GBK"));
        // 将读取到的字符串赋值给line
        String line = br.readLine();
        byte[] bytes = line.getBytes("GBK");
        System.out.println(line + ": 长度" + line.length());
        System.out.println(bytes + ": 长度" + bytes.length);
        /*if (line != null) { // 如果读取到的不为null则说明文件有内容
            System.out.println("读取到的success文件内容 -> {}" + line);
            br.close();
        }*/
    }


    private static String subStringByByte(String str, int len) {
        String result = null;
        if (str != null) {
            byte[] a = str.getBytes();
            if (a.length <= len) {
                result = str;
            } else if (len > 0) {
                result = new String(a, 0, len);
                int length = result.length();
                if (str.charAt(length - 1) != result.charAt(length - 1)) {
                    if (length < 2) {
                        result = null;
                    } else {
                        result = result.substring(0, length - 1);
                    }
                }
            }
        }
        return result;
    }

    public static String getSubString(String targetString, int byteIndex) throws Exception {
        if (targetString.getBytes("GBK").length < byteIndex) {
            throw new Exception("超过长度");
        }
        String temp = targetString;
        for (int i = 0; i < targetString.length(); i++) {
            if (temp.getBytes("GBK").length <= byteIndex) {
                break;
            }
            temp = temp.substring(0, temp.length() - 1);
        }
        return temp;
    }

    /**
     * @param args
     */
    public static void main(String[] args) throws Exception {
        String str1 = "一百二十个字符怎么就那么难弄呢我该说些啥呢算了还是先扯扯把哎还不到120个字啊让我怎么测试asdfghjklqwe哈rtuo";
        byte[] a = str1.getBytes();
        String str2 = getSubString(str1, 100);
        System.out.println("--str1.length=" + str1.length() + "----Byte长度=" + a.length + "-------str2=" + str2 + "------");

    }

    @Test
    public void replace() {
        // 20200710|20200615|100099|14|0|0|611001|14|1543463|882012|6217661599001060644|6217661599001060644|000|882012|156|10.00|||||12340008|008009|123026|||||
        // 20200710|20200615|100099|14|0|0|611002|14|1543470|882012|6217661599001060644|6217661599001060644|000|882012|156|10.00|||||12340008|008010|123215|||||
        String str = "20200710|20200615|100099|14|0|0|611001|14|1543463|882012|6217661599001060644|6217661599001060644|000|882012|156|10.00|||||12340008|008009|123026|||||\n";
        Integer integer1 = 611001;
        Integer integer2 = 1543463;
        Integer integer3 = 108009;
        Integer integer4 = 123026;
        List<String> list = new ArrayList<>();
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int i = 0; i < 11000; i++) {
            Integer integer1add = integer1++;
            Integer integer2add = integer2++;
            Integer integer3add = integer3++;
            Integer integer4add = integer4++;
            String replace = str.replace("611001", integer1add.toString());
            String replace1 = replace.replace("1543463", integer2add.toString());
            String replace2 = replace1.replace("008009", integer3add.toString());
            String replace3 = replace2.replace("123026", integer4add.toString());
            list.add(replace3);
        }
        ArrayList<List<String>> lists = new ArrayList<>();
        lists.add(list);
        WriteUtil.writeList(lists, "/home/gbatch/recon/file/20200712/A00093/OFFLINE/aaa.txt");
    }

    @Test
    public void randomStr() {
        String source = "0123456789";
        Random r = new Random();
        StringBuilder rs = new StringBuilder();
        for (int j = 0; j < 6; j++) {
            int i = r.nextInt(10);
            rs.append(source.charAt(i));
            System.out.println(i);
        }
        System.out.println("rs = " + rs);
    }

    @Test
    public void chinese() {
        String str1 = "（";
        String str2 = "(";
        System.out.println(str1.getBytes(UTF_8).length);
        System.out.println(str2.getBytes(UTF_8).length);
        String str3 = "";
        System.out.println(str3 == null ? "null" : "空串");
    }

    @Test
    public void isBlank() {
        String str = "11111";
        String str2 = "";
        System.out.println(StringUtils.isBlank(str2));
        System.out.println(StringUtils.isNotBlank(str2));
        double v = Math.random() * 10;
        int i = (int) v;
        System.out.println(i);
        System.out.println(StringUtils.isBlank(str));       // false
        System.out.println(StringUtils.isNotBlank(str));    // true
        if (i > 5) {
            str2 = "str2";
        } else {
            str2 = null;
        }
        System.out.println(StringUtils.isBlank(str2));
        System.out.println(StringUtils.isNotBlank(str2));
    }
}
