package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TTerm;

public interface TTermMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TTerm record);

    int insertSelective(TTerm record);

    TTerm selectByPrimaryKey(Integer id);
    
    List findPage(Page page);

    List findTerm();
    
    int updateByPrimaryKeySelective(TTerm record);

    int updateByPrimaryKey(TTerm record);
}