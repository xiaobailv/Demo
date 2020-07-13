package com.liushihao.service;

import com.liushihao.entity.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogServiceTest {

    @Resource
    private LogService logService;

    @Test
    public void queryAll() {
        List<Log> logs = logService.queryAll();
        for (Log log : logs) {
            System.out.println(log);
        }
    }

    @Test
    public void insert() {
        logService.insert(new Log(null, null, new Date(), "222", "222"));
    }

    @Test
    public void drop() {
        logService.drop(new Log().setId("f9001ce695a34cf2ad7436b2a9b7b7d1"));
    }
}
