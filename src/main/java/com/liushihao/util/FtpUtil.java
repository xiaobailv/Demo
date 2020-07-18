package com.liushihao.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * 简单操作FTP工具类 ,此工具类支持中文文件名，不支持中文目录
 * 如果需要支持中文目录，需要 new String(path.getBytes("UTF-8"),"ISO-8859-1") 对目录进行转码
 *
 * @author WZH
 */
@Slf4j
public class FtpUtil {

    /**
     * 获取FTPClient对象
     *
     * @param ftpHost     服务器IP
     * @param ftpPort     服务器端口号
     * @param ftpUserName 用户名
     * @param ftpPassword 密码
     * @return FTPClient
     */
    public static FTPClient getFTPClient(String ftpHost, int ftpPort, String ftpUserName, String ftpPassword) {

        FTPClient ftp = null;
        try {
            ftp = new FTPClient();
            // 连接FPT服务器,设置IP及端口
            ftp.connect(ftpHost, ftpPort);
            // 设置用户名和密码
            ftp.login(ftpUserName, ftpPassword);
            // 设置连接超时时间,5000毫秒
            ftp.setConnectTimeout(50000);
            // 设置中文编码集，防止中文乱码
            ftp.setControlEncoding("UTF-8");
            if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
                log.info("未连接到FTP，用户名或密码错误");
                ftp.disconnect();
            } else {
                log.info("FTP连接成功");
            }

        } catch (SocketException e) {
            e.printStackTrace();
            log.info("FTP的IP地址可能错误，请正确配置");
        } catch (IOException e) {
            e.printStackTrace();
            log.info("FTP的端口错误,请正确配置");
        }
        return ftp;
    }

    /**
     * 关闭FTP方法
     *
     * @param ftp
     * @return
     */
    public static boolean closeFTP(FTPClient ftp) {

        try {
            ftp.logout();
        } catch (Exception e) {
            log.error("FTP关闭失败");
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    log.error("FTP关闭失败");
                }
            }
        }

        return false;

    }

    /**
     * 检查ftp目录是否存在目标文件
     *
     * @param directory ftp目录
     * @param fileName  需要下载的文件名
     * @return
     */
    public static boolean checkListNames(FTPClient ftpClient, String directory, String fileName) throws Exception {
        String fileNames[] = null;
        String ftpName = "";
        fileNames = ftpClient.listNames(directory);
        if (fileNames != null && fileNames.length > 0) {
            for (int i = 0; i < fileNames.length; i++) {
                ftpName = fileNames[i].substring(fileNames[i].lastIndexOf("/") + 1, fileNames[i].length());
                if (ftpName.equals(fileName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 下载FTP下指定文件
     *
     * @param ftp      FTPClient对象
     * @param filePath FTP文件路径
     * @param fileName 文件名
     * @param downPath 下载保存的目录
     * @return
     */
    public static boolean downLoadFTP(FTPClient ftp, String filePath, String fileName, String downPath) {
        // 默认失败
        boolean flag = false;

        try {
            // 跳转到文件目录
            ftp.changeWorkingDirectory(filePath);
            // 获取目录下文件集合
            ftp.enterLocalPassiveMode();
            FTPFile[] files = ftp.listFiles(filePath);
            for (FTPFile file : files) {
                String fileNameGbk = new String(file.getName().getBytes("GBK"), StandardCharsets.UTF_8);
                System.out.println("file.getName() = " + fileNameGbk);
                System.out.println("fileName = " + fileName);
                if (file.getName().equals(fileName)) {
                    File downFile = new File(downPath + "/" + file.getName());
                    System.out.println("downFile = " + downFile);
                    File downPathFile = new File(downPath);
//                    System.out.println(downPath+File.separator+file.getName());
//                    System.out.println(downPathFile.getName().toString());
                    if (!downPathFile.exists()) {
                        downPathFile.mkdirs();
                        downFile.createNewFile();
                    } else {
                        if (downFile.exists()) {
                            downFile.delete();
                            downFile.createNewFile();

                        } else {
                            downFile.createNewFile();
                        }
                    }
                    OutputStream out = new FileOutputStream(downFile);
                    // 绑定输出流下载文件,需要设置编码集，不然可能出现文件为空的情况
                    flag = ftp.retrieveFile(new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"), out);
                    // 下载成功删除文件,看项目需求
                    //  ftp.deleteFile(new String(fileName.getBytes("UTF-8"),"ISO-8859-1"));
                    out.flush();
                    out.close();
                    if (flag) {
                        log.info("下载成功");
                    } else {
                        log.error("下载失败");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("下载失败");
        }

        return flag;
    }

    /**
     * FTP文件上传工具类
     *
     * @param ftp      ftp信息
     * @param filePath 本地文件的路径+文件名
     * @param ftpPath  ftp的路径
     * @return
     */
    public static boolean uploadFile(FTPClient ftp, String filePath, String ftpPath) {
        boolean flag = false;
        InputStream in = null;
        try {
            // 设置PassiveMode传输
            ftp.enterLocalPassiveMode();
            //设置二进制传输，使用BINARY_FILE_TYPE，ASC容易造成文件损坏
            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            //判断FPT目标文件夹时候存在不存在则创建
            if (!ftp.changeWorkingDirectory(ftpPath)) {
                ftp.makeDirectory(ftpPath);
            }
            //跳转目标目录
            ftp.changeWorkingDirectory(ftpPath);

            //上传文件
            File file = new File(filePath);
            in = new FileInputStream(file);
            String tempName = ftpPath + File.separator + file.getName();
            System.out.println(filePath);
            System.out.println(tempName);
            flag = ftp.storeFile(new String(tempName.getBytes("GBK"), "ISO-8859-1"), in);
            if (flag) {
                log.info("上传成功");
            } else {
                log.error("上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("上传失败");
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * FPT上文件的复制
     *
     * @param ftp      FTPClient对象
     * @param olePath  原文件地址
     * @param newPath  新保存地址
     * @param fileName 文件名
     * @return
     */
    public static boolean copyFile(FTPClient ftp, String olePath, String newPath, String fileName) {
        boolean flag = false;

        try {
            // 跳转到文件目录
            ftp.changeWorkingDirectory(olePath);
            //设置连接模式，不设置会获取为空
            ftp.enterLocalPassiveMode();
            // 获取目录下文件集合
            FTPFile[] files = ftp.listFiles();
            ByteArrayInputStream in = null;
            ByteArrayOutputStream out = null;
            for (FTPFile file : files) {
                // 取得指定文件并下载
                if (file.getName().equals(fileName)) {

                    //读取文件，使用下载文件的方法把文件写入内存,绑定到out流上
                    out = new ByteArrayOutputStream();
                    ftp.retrieveFile(new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"), out);
                    in = new ByteArrayInputStream(out.toByteArray());
                    //创建新目录
                    ftp.makeDirectory(newPath);
                    //文件复制，先读，再写
                    //二进制
                    ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
                    flag = ftp.storeFile(newPath + File.separator + (new String(file.getName().getBytes("UTF-8"), "ISO-8859-1")), in);
                    out.flush();
                    out.close();
                    in.close();
                    if (flag) {
                        log.info("转存成功");
                    } else {
                        log.error("复制失败");
                    }


                }
            }
        } catch (Exception e) {
            log.error("复制失败");
        }
        return flag;
    }

    /**
     * 实现文件的移动，这里做的是一个文件夹下的所有内容移动到新的文件，
     * 如果要做指定文件移动，加个判断判断文件名
     * 如果不需要移动，只是需要文件重命名，可以使用ftp.rename(oleName,newName)
     *
     * @param ftp
     * @param oldPath
     * @param newPath
     * @return
     */
    public static boolean moveFile(FTPClient ftp, String oldPath, String newPath) {
        boolean flag = false;

        try {
            ftp.changeWorkingDirectory(oldPath);
            ftp.enterLocalPassiveMode();
            //获取文件数组
            FTPFile[] files = ftp.listFiles();
            //新文件夹不存在则创建
            if (!ftp.changeWorkingDirectory(newPath)) {
                ftp.makeDirectory(newPath);
            }
            //回到原有工作目录
            ftp.changeWorkingDirectory(oldPath);
            for (FTPFile file : files) {

                //转存目录
                flag = ftp.rename(new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"), newPath + File.separator + new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"));
                if (flag) {
                    log.info(file.getName() + "移动成功");
                } else {
                    log.error(file.getName() + "移动失败");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("移动文件失败");
        }
        return flag;
    }

    /**
     * 删除FTP上指定文件夹下文件及其子文件方法，添加了对中文目录的支持
     *
     * @param ftp       FTPClient对象
     * @param FtpFolder 需要删除的文件夹
     * @return
     */
    public static boolean deleteByFolder(FTPClient ftp, String FtpFolder) {
        boolean flag = false;
        try {
            ftp.changeWorkingDirectory(new String(FtpFolder.getBytes("UTF-8"), "ISO-8859-1"));
            ftp.enterLocalPassiveMode();
            FTPFile[] files = ftp.listFiles();
            for (FTPFile file : files) {
                //判断为文件则删除
                if (file.isFile()) {
                    ftp.deleteFile(new String(file.getName().getBytes("UTF-8"), "ISO-8859-1"));
                }
                //判断是文件夹
                if (file.isDirectory()) {
                    String childPath = FtpFolder + File.separator + file.getName();
                    //递归删除子文件夹
                    deleteByFolder(ftp, childPath);
                }
            }
            //循环完成后删除文件夹
            flag = ftp.removeDirectory(new String(FtpFolder.getBytes("UTF-8"), "ISO-8859-1"));
            if (flag) {
                log.info(FtpFolder + "文件夹删除成功");
            } else {
                log.error(FtpFolder + "文件夹删除成功");
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("删除失败");
        }
        return flag;

    }

    /**
     * 检查ftp目录是否存在目标文件
     *
     * @param directory ftp目录
     * @param fileName  需要下载的文件名
     * @return
     */
    public static boolean checkListFiles(FTPClient ftp, String directory, String fileName) {
        boolean result = false;
        try {
            FTPFile[] listFiles = ftp.listFiles(directory);
            if (listFiles != null) {
                for (FTPFile ftpFile : listFiles) {
                    String ftpFileName = ftpFile.getName();
                    //     System.out.println("ftpfilename："+ftpFileName);
                    //     System.out.println(fileName);
                    if (fileName.equals(ftpFileName)) {
                        result = true;
                        break;
                    }
                }
                if (!result) {

                    log.info("-----未在ftp找到文件：{}/{}----", directory, fileName);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 遍历解析文件夹下所有文件
     *
     * @param folderPath 需要解析的的文件夹
     * @param ftp        FTPClient对象
     * @param endName
     * @return
     */
    public static boolean readFileByFolder(FTPClient ftp, String folderPath, String endName) {
        boolean flage = false;
        try {
            ftp.changeWorkingDirectory(new String(folderPath.getBytes("UTF-8"), "ISO-8859-1"));
            //设置FTP连接模式
            ftp.enterLocalPassiveMode();
            //获取指定目录下文件文件对象集合
            FTPFile files[] = ftp.listFiles();
            InputStream in = null;
            BufferedReader reader = null;
            for (FTPFile file : files) {
                if (endName.equals(file.getName())) {
                    flage = true;
                }
               /* //判断为txt文件则解析
                if(file.isFile()){
                    String fileName = file.getName();
                    if(fileName.endsWith(endName)){
                        in = ftp.retrieveFileStream(new String(file.getName().getBytes("UTF-8"),"ISO-8859-1"));
                        reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                        String temp;
                        StringBuffer buffer = new StringBuffer();
                        while((temp = reader.readLine())!=null){
                            buffer.append(temp);
                        }
                        if(reader!=null){
                            reader.close();
                        }
                        if(in!=null){
                            in.close();
                        }
                        //ftp.retrieveFileStream使用了流，需要释放一下，不然会返回空指针
                        ftp.completePendingCommand();
                        //这里就把一个txt文件完整解析成了个字符串，就可以调用实际需要操作的方法
                        System.out.println(buffer.toString());
                    }
                }
                //判断为文件夹，递归
                if(file.isDirectory()){
                    String path = folderPath+File.separator+file.getName();
                    readFileByFolder(ftp, path,endName);
                }*/
            }


        } catch (Exception e) {
            e.printStackTrace();
            log.error("文件解析失败");
        }

        return flage;

    }

    /*
     * 从FTP服务器下载文件
     * @param ftpHost             FTP IP地址
     * @param ftpUserName         FTP 用户名
     * @param ftpPassword         FTP用户名密码
     * @param ftpPort             FTP端口
     * @param ftpPath             FTP服务器中文件所在路径 格式： ftptest/aa
     * @param localPath           下载到本地的位置 格式：H:/download
     * @param fileName            FTP服务器上要下载的文件名称
     * @param targetFileName      FTP服务器上要下载的文件名称
     */
    public static void downloadFtpFile(String ftpHost, String ftpUserName, String ftpPassword, int ftpPort, String ftpPath, String localPath, String fileName, String targetFileName) {

        FTPClient ftpClient = null;
        try {
            ftpClient = getFTPClient(ftpHost, ftpPort, ftpUserName, ftpPassword);
            ftpClient.changeWorkingDirectory(ftpPath);

            String f_ame = new String(fileName.getBytes("GBK"), FTP.DEFAULT_CONTROL_ENCODING);    //编码文件格式,解决中文文件名

            File localFile = new File(localPath + File.separatorChar + targetFileName);
            OutputStream os = new FileOutputStream(localFile);
            ftpClient.retrieveFile(f_ame, os);
            os.close();
            ftpClient.logout();

        } catch (FileNotFoundException e) {
            log.error("没有找到" + ftpPath + "文件");
            e.printStackTrace();
        } catch (SocketException e) {
            log.error("连接FTP失败.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            log.error("文件读取错误。");
            e.printStackTrace();
        }
    }
}