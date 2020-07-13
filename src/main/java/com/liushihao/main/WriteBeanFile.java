package com.liushihao.main;

import com.liushihao.entity.Admin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/22 16:05
 */
public class WriteBeanFile {

    public static void main(String[] args) throws IOException {
        Admin admin = new Admin("1", "刘世豪", "123456", "123456");
        /*File file = new File("D:\\Download\\admin.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        // FileOutputStream
        FileOutputStream oos = new FileOutputStream(file);
        // 开始写入
        String strAdmin = admin.getId() + admin.getUsername() + admin.getPassword() + admin.getSalt();
        oos.write(strAdmin.getBytes());
        // 关流
        oos.close();*/

        // Files
        String strAdmin = admin.getId() + admin.getUserName() + admin.getPassword() + admin.getSalt() + "\n";
        ArrayList<String> list = new ArrayList<>();
        list.add(strAdmin);
        list.add(strAdmin);
        list.add(strAdmin);
//        Files.write(Paths.get("D:\\Download\\admin.txt"), list, Charset.forName("GBK"));
//        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("D:\\Download\\admin.txt"), "GBK");
//        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        File file = new File("D:\\Download\\admin.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file, true);
        try {
            for (String s : list) {
                fileWriter.write(s);
            }
        } catch (Exception e) {
            System.out.println("写入文件失败...");
        } finally {
            fileWriter.close();
//            outputStreamWriter.close();
        }
        System.out.println("处理完毕...");
    }
}
