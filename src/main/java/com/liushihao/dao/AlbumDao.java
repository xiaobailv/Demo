package com.liushihao.dao;

import com.liushihao.entity.Album;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.additional.idlist.DeleteByIdListMapper;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AlbumDao extends Mapper<Album>, DeleteByIdListMapper<Album, String> {

    // 根据count查询
    List<Album> selectBycount(@Param("count") Integer count);
}
