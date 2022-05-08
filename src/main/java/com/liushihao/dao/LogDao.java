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

    /**
     * 新增
     * @param log 根据实体信息查询
     */
    /*void add(Log log);*/

    /**
     * 查所有
     * @return Log集合
     */
    /*List<Log> selectAll();*/


    /**
     * 根据id和name查询
     * @param id id
     * @param name name
     * @return Log集合
     */
    List<Log> selectById(@Param("id") String id, @Param("name") String name);


    /*List<Map<String, Object>> selectAllNameAndResult();*/

    /**
     * 查询姓名和时间
     * @return LogNameAndResultDto集合
     */
    List<LogNameAndResultDto> selectAllNameAndResult();
}
