package com.liushihao.dao;

import com.liushihao.entity.Log;
import com.liushihao.entity.LogNameAndResultDto;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author 刘世豪
 * @title
 * @description
 * @updateTime 2020/5/29 11:36
 */
public interface LogDao extends Mapper<Log> {

    /*// 插入
    public void add(Log log);

    // 查所有
    public List<Log> selectAll();*/


    // 查询
    List<Log> selectById(@Param("id") String id, @Param("name") String name);

    // 查询姓名和时间
    /*List<Map<String, Object>> selectAllNameAndResult();*/
    List<LogNameAndResultDto> selectAllNameAndResult();
}
