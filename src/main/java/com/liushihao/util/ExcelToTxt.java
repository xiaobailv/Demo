package com.liushihao.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;

import java.io.*;

/**
 * @author 刘世豪
 */
public class ExcelToTxt {

    /**
     * 根据excel文件生成对应的sql语句
     *
     * @param sourcePath excel文件路径
     */
    public static void generateInsertSql(String sourcePath, String targetPath) throws IOException {
        FileInputStream fis = new FileInputStream(new File(sourcePath));
        FileOutputStream fos = new FileOutputStream(new File(targetPath));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis, "GBK"));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
            bufferedWriter.write(str);
        }
        fis.close();
        bufferedReader.close();
        fos.close();
        bufferedWriter.close();
    }

    public static void generateInsertSql(String sourcePath, Class classes) {
        ExcelReader excelReader = EasyExcel.read(sourcePath).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        excelReader.finish();
    }
}
