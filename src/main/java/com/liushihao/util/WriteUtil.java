package com.liushihao.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteUtil {

    /**
     *
     * @param path  指定生成文件的路径
     * @param context   指定写入文件的内容
     * @return  返回写文件的结果 "成功"|"失败"
     */
    public static String write(String path, String context, Boolean append) {
        String result;   // 返回的flag
        String directory = path.substring(0, path.lastIndexOf("/"));
        File file1 = new File(directory);
        if (!file1.exists()) {   // 如果文件路径不存在则创建
            file1.mkdirs();
        }
        File file = new File(path); // 创建路径和文件
        if (!file.exists()) {   // 如果文件路径不存在则创建
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("创建文件失败...");
            }
        }
        try (FileWriter fileWriter = new FileWriter(file, append)) {  // 此处的true表示可以向文件中追加内容
            fileWriter.write(context);
            System.out.println("写入成功!!!" + (append ? "追加" : "非追加"));
            fileWriter.close();
            result = "成功";
        } catch (Exception e) {
            e.printStackTrace();
            result = "失败";
        }
        return result;
    }
}
