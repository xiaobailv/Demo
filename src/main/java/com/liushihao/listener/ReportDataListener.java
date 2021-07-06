package com.liushihao.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.liushihao.entity.Report;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author 刘世豪
 */
@Slf4j
public class ReportDataListener extends AnalysisEventListener<Report> {

    private static String INSERT_SQL = "insert into tableName (%s) values (%s);";

    private static StringBuilder columnStringBuilder = new StringBuilder();

    private static StringBuilder valueStringBuilder = new StringBuilder();

    public ReportDataListener() {
    }

    @SneakyThrows
    @Override
    public void invoke(Report report, AnalysisContext analysisContext) {

//        log.info("解析到一条数据:{}", JSON.toJSONString(report));
        Class<? extends Report> aClass = report.getClass();
        Field[] fields = aClass.getDeclaredFields();
        for (int i = 0; i < fields.length - 1; i++) {
            Field field = fields[i];
            String fieldName = field.getName();

            // 获取到字段名
            columnStringBuilder.append(fieldName).append(", ");
            PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, aClass);
            Method readMethod = propertyDescriptor.getReadMethod();

            // 获取到字段值
            // TODO 后续如果需要的话, 可以实现根据值的数据类型设置对应的sql字段, 如('字符串', 123...)
            String value = (String) readMethod.invoke(report);
            valueStringBuilder.append("\'").append(value).append("\',");
        }
        Field field = fields[fields.length - 1];
        String fieldName = field.getName();

        // 组装最后一个column
        columnStringBuilder.append(fieldName);

        // 组装最后一个value
        PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, aClass);
        Method readMethod = propertyDescriptor.getReadMethod();
        String value = (String) readMethod.invoke(report);
        valueStringBuilder.append("\'").append(value).append("\'");

        // 组装SQL语句
        String insertSql = String.format(INSERT_SQL, columnStringBuilder.toString(), valueStringBuilder.toString()) + "\n";

        // 写入txt文件
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("D:/CCB/File/20210723/INSERT_SQL.txt"), true));
        osw.write(insertSql);
        osw.close();

        // 组装完毕后将StringBuilder清空
        columnStringBuilder.delete(0, columnStringBuilder.length());
        valueStringBuilder.delete(0, valueStringBuilder.length());
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("所有数据解析完成!");
    }
}
