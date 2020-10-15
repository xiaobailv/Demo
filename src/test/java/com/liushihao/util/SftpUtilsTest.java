package com.liushihao.util;

import org.junit.Test;

import java.util.Vector;

public class SftpUtilsTest {

    @Test
    public void getConnect() throws Exception {
        SftpUtils sftpUtils = new SftpUtils("49.232.15.233", 22, "liush", "liush");

        // 连接
//        ChannelSftp connect = sftpUtils.connect();
//        System.out.println("connect = " + connect.pwd());

        // 上传
//        boolean b = sftpUtils.uploadFile("/home/liush/train/tmp/tmp1/", "JMM Java内存模型.png", "D:/Download/", "JMM Java内存模型.png");
//        System.out.println("b = " + b);

        // 下载
//        sftpUtils.downloadFile("/home/liush/train/tmp/tmp1/", "JMM Java内存模型.png", "D:/Download/", "JMM Java内存模型DWL.png");

        // 判断远端目录是否存在
        boolean dirExist = sftpUtils.isDirExist("/home/liush/train/tmp/tmp1/");
        System.out.println("dirExist = " + dirExist);

        // 列出目录文件
        Vector vector = sftpUtils.listFiles("/home/liush/train");
        for (Object o : vector) {
            System.out.println("o = " + o);
        }
    }
}
