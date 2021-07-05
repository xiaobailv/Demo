package com.liushihao.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.liushihao.entity.Report;
import com.liushihao.listener.ReportDataListener;
import org.junit.Test;

import java.io.IOException;

public class ExcelToTxtTest {

    @Test
    public void simpleRead() {
        // String fileName = "D:/CCB/File/20210723/0723-产品化报表表结构111.xlsx";
        String fileName = "D:/File/Learn/EasyExcel/数据库表.xlsx";

        // 写法1:
//        EasyExcel.read(fileName, Report.class, new ReportDataListener()).sheet().doRead();

        // 写法2:
        ExcelReader excelReader = EasyExcel.read(fileName, Report.class, new ReportDataListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 关流
        excelReader.finish();
    }
}
