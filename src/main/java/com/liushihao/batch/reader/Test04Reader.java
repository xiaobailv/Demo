package com.liushihao.batch.reader;

import com.liushihao.dao.LogDao;
import com.liushihao.entity.Log;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@StepScope
public class Test04Reader implements ItemReader<List<Log>> {

    private Boolean flag = true;

    @Autowired
    private LogDao logDao;

    @Override
    public List<Log> read() {
        System.out.println("进入Test04的Reader...");
        List<Log> logs;
        if (flag) {
            logs = logDao.selectAll();
            if (logs.size() != 0) {
                flag = false;
            }
            return logs;
        }
        System.out.println("结束Test04的Reader...");
        return null;
    }
}
