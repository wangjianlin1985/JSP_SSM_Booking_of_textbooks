package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TBook;

public interface TBookMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TBook record);

    int insertSelective(TBook record);

    TBook selectByPrimaryKey(Integer id);
    
    List findPage(Page page);


    int updateByPrimaryKeySelective(TBook record);

    int updateByPrimaryKey(TBook record);
}