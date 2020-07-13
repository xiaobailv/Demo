package com.liushihao.service;

import com.liushihao.entity.Log;

import java.util.List;

public interface LogService {

    // 插入
    public void insert(Log log);

    // 查所有
    public List<Log> queryAll();

    // 删除
    public void drop(Log log);
}
