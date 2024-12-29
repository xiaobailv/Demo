package com.liushihao.util;

import com.liushihao.excelToJava.ExcelFileGen;
import com.liushihao.excelToJava.ExcelInfo;
import com.liushihao.excelToJava.VoInfo;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 11092
 * @Description
 * @create 2024-08-10 16:27
 */
public class ExcelToVoJava {

    public static void main(String[] args) {
        ExcelInfo excelInfo = new ExcelInfo();
        excelInfo.setTxnName("A00000000");
        List<VoInfo> voInfoList = new ArrayList<>();
        voInfoList.add(new VoInfo("申请书编号", "spInstm_Apl_ID", "String"));
        voInfoList.add(new VoInfo("请款编号", "SpInstm_AplyForLoan_ID", "String"));
        excelInfo.setVoInfoList(voInfoList);
        ExcelFileGen fileGen = new ExcelFileGen(excelInfo);
        fileGen.genFiles();
    }

    public static void readExcel() {
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("D:/File/Learn/EasyExcel/交易接口.xlsx"));
            XSSFSheet sheet = workbook.getSheetAt(2);
            int rowMax = sheet.getLastRowNum();
            for (int row = 0; row < rowMax; row++) {
                String firstCell = sheet.getRow(row).getCell(0).toString();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
