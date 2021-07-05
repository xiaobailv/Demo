package com.liushihao.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.fastjson.JSON;
import com.liushihao.entity.Report;
import lombok.extern.slf4j.Slf4j;

/**
 * @author 刘世豪
 */
@Slf4j
public class ReportDataListener extends AnalysisEventListener<Report> {

    private static String INSERT_SQL = "insert into %s (%s) values (%s);";

    private static final String TABLE_NAME = "TABLE_NAME";

    public ReportDataListener() {
    }

    @Override
    public void invoke(Report report, AnalysisContext analysisContext) {
        log.info("解析到一条数据:{}", JSON.toJSONString(report));

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("所有数据解析完成!");
    }
}
