package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TClass;

public interface TClassMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TClass record);

    int insertSelective(TClass record);

    TClass selectByPrimaryKey(Integer id);

    List findPage(Page page);
    
    List findClass();
    
    int updateByPrimaryKeySelective(TClass record);

    int updateByPrimaryKey(TClass record);
}