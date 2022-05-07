package com.liushihao.junit;

public class MainTest {

    public static void main(String[] args) {
        String str = "abcdefghijklmn";
        System.out.println(revert(str));

        Integer i1 = 01523;
        System.out.println("00000" + i1);
//
////        float [][]f = new float[6][];
////        split(12);

//        Boolean flag = false;
//        if (flag = true) {
//            System.out.println("true");
//        } else {
//            System.out.println("false");
//        }
    }

    public static String revert(String string) {
        long start = System.currentTimeMillis();
        char[] chars = string.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            chars[i] = string.charAt(length - 1 - i);
        }
        String s = new String(chars);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        return s;
    }

    // 6 3 2 1
    public static int split(int number) {
        if (number > 1) {
            if (number % 2 != 0)
                System.out.println(split((number + 1) / 2));    // 3
            System.out.println(split(number / 2));  // 1 2 4
        }
        return number;
    }

//    static int arr[] = new int[5];

    /*private static Boolean booleanTest() {
        Integer a = 10;
        return a == 2;
    }*/

    /*private static String fileClose() throws IOException {
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
    }*/
}
