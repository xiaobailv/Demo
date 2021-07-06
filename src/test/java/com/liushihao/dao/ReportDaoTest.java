package com.liushihao.dao;

import com.liushihao.entity.Report;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Description 报表类查询数据库测试
 * @Author 刘世豪
 * @Date 2021/7/6
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class ReportDaoTest {

    @Autowired
    private ReportDao reportDao;

    @Test
    public void selectAll() {
        List<Report> reports = reportDao.selectAll();
        if (reports.size() > 0) {
            for (Report report : reports) {
                System.out.println("report = " + report);
            }
        } else {
            System.out.println("未查询到数据!!!");
        }
    }
}
