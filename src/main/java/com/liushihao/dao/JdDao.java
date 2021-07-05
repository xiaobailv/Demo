package com.liushihao.dao;

import com.liushihao.entity.Jd;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

public interface JdDao extends BaseMapper<Jd> {

    int batchInsert(List<Jd> jds);

    List<Jd> selectByCondition(Jd jd);

    int deleteById(Jd jd);
}
