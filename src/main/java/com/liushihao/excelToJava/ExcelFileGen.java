package com.liushihao.excelToJava;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description 根据转换的excel对象生成java文件
 * @author 11092
 * @create 2024-08-10 14:43
 */
public class ExcelFileGen {

    private Configuration configuration;

    private String outputDir;

    private ExcelInfo excelInfo;

    public ExcelFileGen(ExcelInfo excelInfo) {
        init(excelInfo);
    }

    private void init(ExcelInfo excelInfo) {
        this.excelInfo = excelInfo;
        configuration = new Configuration();
        String path = ExcelFileGen.class.getResource("/").getPath();
        outputDir = path + "Output/";
        File pathDir = new File(outputDir);
        pathDir.mkdir();
        try {
            configuration.setDirectoryForTemplateLoading(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void genFiles() {
        String[] templateList = {"/excel/InVo.java.ftl"};
        for (String template : templateList) {
            genFile(template);
        }
    }

    private void genFile(String templateName) {
        int lastIndexOf = templateName.lastIndexOf(".ftl");
        int indexOf = templateName.lastIndexOf("/");
        String fullName = outputDir + excelInfo.getTxnName() + templateName.substring(indexOf + 1, lastIndexOf);
        try {
            PrintWriter writer = new PrintWriter(fullName);
            Template template = configuration.getTemplate(templateName);
            template.process(excelInfo, writer);
            writer.close();
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }
    }
}
