package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TSerie;

public interface TSerieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TSerie record);

    int insertSelective(TSerie record);

    TSerie selectByPrimaryKey(Integer id);

    List findPage(Page page);
    
    List findSerie();
    
    int updateByPrimaryKeySelective(TSerie record);

    int updateByPrimaryKey(TSerie record);
}