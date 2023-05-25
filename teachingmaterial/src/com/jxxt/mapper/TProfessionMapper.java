package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TProfession;

public interface TProfessionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TProfession record);

    int insertSelective(TProfession record);

    TProfession selectByPrimaryKey(Integer id);
    
    List findPage(Page page);
    
    List findProfession();

    int updateByPrimaryKeySelective(TProfession record);

    int updateByPrimaryKey(TProfession record);
}