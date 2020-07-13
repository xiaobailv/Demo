package com.liushihao.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteLogUtil {

    public static String write(String path, String context) {
        String result;
        File file = new File(path);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("创建文件失败...");
            }
        }
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            fileWriter.write(context);
            System.out.println("写入成功!!!");
            fileWriter.close();
            result = "成功";
        } catch (Exception e) {
            e.printStackTrace();
            result = "失败";
        }
        return result;
    }
}
