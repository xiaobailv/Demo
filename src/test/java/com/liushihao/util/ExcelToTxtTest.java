package com.liushihao.util;

import com.alibaba.excel.EasyExcel;
import com.liushihao.dao.ReportDao;
import com.liushihao.entity.Report;
import com.liushihao.listener.ReportDataListener;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ExcelToTxtTest {

    @Autowired
    private ReportDao reportDao;

    @Test
    public void simpleRead() {
         String fileName = "D:/CCB/File/20210723/0723-产品化报表表结构111.xlsx";
//        String fileName = "D:/File/Learn/EasyExcel/数据库表.xlsx";

        // 写法1:
        EasyExcel.read(fileName, Report.class, new ReportDataListener()).sheet().doRead();

        // 写法2:
        /*ExcelReader excelReader = EasyExcel.read(fileName, Report.class, new ReportDataListener()).build();
        ReadSheet readSheet = EasyExcel.readSheet(0).build();
        excelReader.read(readSheet);
        // 关流
        excelReader.finish();*/
    }

    @Test
    public void simpleWrite() {
//        String fileName = "D:/CCB/File/20210723/simpleWrite" + System.currentTimeMillis() + ".xlsx";
        String fileName = "D:/CCB/File/20210723/simpleWrite.xlsx";
        System.out.println("fileName = " + fileName);

        // 准备数据
        List<Report> reports = reportDao.selectAll();

        // 写法1
        // 这里需要指定用哪个class去写, 写到第一个sheet, 名字为模板, 然后文件流会自动关闭
        // 如果这里想使用03则传入excelType即可
        EasyExcel.write(fileName, Report.class).sheet("模板").doWrite(reports);

        // 写法2
        /*ExcelWriter excelWriter = null;
        try {
            excelWriter = EasyExcel.write(fileName, Report.class).build();
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            excelWriter.write(reports, writeSheet);
        } finally {
            // 千万别忘记finish会帮忙关流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }*/
    }
}
