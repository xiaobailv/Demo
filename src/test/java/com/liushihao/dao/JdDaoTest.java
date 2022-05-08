package com.liushihao.dao;

import com.liushihao.entity.Jd;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class JdDaoTest {

    @Resource
    private JdDao jdDao;

    @Test
    public void query() {
        List<Jd> jds = jdDao.selectAll();
        for (Jd jd : jds) {
            System.out.println("jd = " + jd);
        }
    }

    @Test
    public void batchInsert() {
        int batchInsert = 0;
        try {
            List<Jd> jds = new ArrayList<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
            Date birthday = sdf.parse("20201225");
            jds.add(new Jd("3", "333", "男", "33333333333", "3333333333@qq.com", "3333333", birthday));
            jds.add(new Jd("4", "444", "男", "44444444444", "4444444444@qq.com", "4444444", birthday));
            jds.add(new Jd("5", "555", "男", "55555555555", "5555555555@qq.com", "5555555", birthday));
            batchInsert = jdDao.batchInsert(jds);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("日期转换异常");
        }
        System.out.println("batchInsert = " + batchInsert);
    }

    @Test
    public void selectByCondition() {
        Jd jd = new Jd();
        jd.setId("30");
        jd.setSex("女");
        jd.setMobile("15555555555");
        List<Jd> jds = jdDao.selectByCondition(jd);
        for (Jd jd1 : jds) {
            System.out.println(jd1);
        }
    }

    @Test
    public void deleteById() {
        Jd jd = new Jd();
        jd.setId("44");
        System.out.println("删除了 " + jdDao.deleteById(jd) + " 条数据");
        System.out.println(jdDao.selectByPrimaryKey("44"));
    }
}
