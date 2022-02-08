package com.liushihao.service;

import com.liushihao.entity.Log;

import java.util.List;

public interface LogService {

    /**
     * 插入
     * @param log 日志类
     */
    void insert(Log log);

    /**
     * 查询所有
     * @return Log集合
     */
    List<Log> queryAll();

    /**
     * 删除
     * @param log 根据参数删除数据
     */
    void drop(Log log);
}
