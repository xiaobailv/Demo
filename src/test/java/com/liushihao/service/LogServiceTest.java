package com.liushihao.service;

import com.liushihao.entity.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class LogServiceTest {

    @Autowired
    private LogService logService;
    @Value("${test.name}")
    private String name;
    @Value("${test.length}")
    private String length;

    @Test
    public void queryAll() {
        System.out.println(name);
        System.out.println(length);
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
