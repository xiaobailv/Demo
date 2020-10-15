package com.liushihao.util;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

public class FTPTest {

    @Test
    public void download() {
        FTPClient ftpClient = FtpUtil.getFTPClient("192.168.40.1", 21, "1109214102@qq.com", "lsh13137132561");
        FtpUtil.downLoadFTP(ftpClient, "", "jetbrains-agent.jar", "D:\\");
//        FtpUtil.downloadFtpFile("192.168.40.1", "1109214102@qq.com", "lsh13137132561", 21, "D:\\FtpServer", "D:\\", "JMM Java内存.png", "JMM Java内存模型.png");
//        FtpUtils.downloadFtpFile("192.168.40.1", "1109214102@qq.com", "lsh13137132561", 21, "D:\\FtpServer", "D:\\", "111.png", "111.png");
    }

    @Test
    public void upload() {
        FTPClient ftpClient = FtpUtil.getFTPClient("192.168.40.1", 21, "1109214102@qq.com", "lsh13137132561");
//        FTPClient ftpClient = FtpUtil.getFTPClient("192.168.40.1", 21, "IUSR", null);
        FtpUtil.uploadFile(ftpClient, "D:\\Download\\JMM Java内存模型.png", "");
        FtpUtil.uploadFile(ftpClient, "D:\\Download\\jetbrains-agent.jar", "");
    }
}
