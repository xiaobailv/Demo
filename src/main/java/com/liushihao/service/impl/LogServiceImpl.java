package com.liushihao.service.impl;

import com.liushihao.aspect.LogAspect;
import com.liushihao.dao.LogDao;
import com.liushihao.entity.Log;
import com.liushihao.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/29 14:14
 */
@Slf4j
@Service
@Transactional
public class LogServiceImpl implements LogService {

    @Autowired
    private LogDao logDao;

    @Override
    @LogAspect(operationName = "执行了插入操作", fileName = "E:\\Download\\log.txt")
    public void insert(Log log) {
        log.setId(UUID.randomUUID().toString().replace("-", ""));
        logDao.insert(log);
    }

    @Override
    @LogAspect(operationName = "执行了查询所有操作", fileName = "E:\\Download\\log.txt")
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<Log> queryAll() {
        List<Log> logs = logDao.selectAll();
        return logs;
    }

    @Override
    @LogAspect(operationName = "执行了删除操作", fileName = "E:\\Download\\log2.txt")
    public void drop(Log log) {
        logDao.delete(log);
        int i = 1 / 0;
    }
}
