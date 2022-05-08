package com.liushihao.dao;

import com.liushihao.entity.Log;
import com.liushihao.entity.LogNameAndResultDto;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LogDaoTest {

    @Autowired
    private LogDao logDao;

    @Test
    public void add() {
        logDao.insert(new Log("1", "test", new Date(), "111", "111"));
    }

    @Value("${testSpace}")
    private String[] testSpace;

    @Test
    public void selectAll() {
        List<Log> logs = logDao.selectAll();
        for (Log log : logs) {
            System.out.println(log);
        }
        for (int i = 0; i < testSpace.length; i++) {
            String s = testSpace[i];
            System.out.println("s = " + s);
        }
    }

    @Test
    @Rollback
    public void insert() {
        Log log = new Log();
        log.setId(String.valueOf(System.currentTimeMillis()));
        log.setDate(new Date());
        log.setMethod("Method");
        log.setResult("Result");
        int insert = logDao.insert(log);
        System.out.println("insert = " + insert);
    }

    @Test
    public void selectAllNameAndDate() {
        /*Map<String, String> hashMap = new HashMap<>();
        List<Map<String, Object>> maps = logDao.selectAllNameAndResult();
        for (Map<String, Object> map : maps) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String name = null;
                String result = null;
                if ("name".equals(entry.getKey())) {
                    name = String.valueOf(entry.getValue());
                } else if ("result".equals(entry.getKey())) {
                    result = String.valueOf(entry.getValue());
                }
                hashMap.put(name, result);
            }
        }
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            System.out.println("entry.getKey() = " + entry.getKey() + " --- entry.getValue() = " + entry.getValue());
        }*/
        List<LogNameAndResultDto> logNameAndResultDtos = logDao.selectAllNameAndResult();
        for (LogNameAndResultDto logNameAndResultDto : logNameAndResultDtos) {
            System.out.println("logNameAndResultDto = " + logNameAndResultDto);
        }
        System.out.println("logNameAndResultDtos.size() = " + logNameAndResultDtos.size());
    }
}
