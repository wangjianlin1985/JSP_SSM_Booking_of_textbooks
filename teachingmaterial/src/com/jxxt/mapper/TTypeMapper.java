package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TType;

public interface TTypeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TType record);

    int insertSelective(TType record);

    List findPage(Page page);

    List findType();
    
    TType selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TType record);

    int updateByPrimaryKey(TType record);
}