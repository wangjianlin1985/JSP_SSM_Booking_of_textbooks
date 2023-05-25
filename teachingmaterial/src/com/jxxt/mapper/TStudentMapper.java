package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TStudent;

public interface TStudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    TStudent selectByPrimaryKey(Integer id);
   
    List findPage(Page page);

    int selectCount();
    
    TStudent selectStuLogin(String stuNo);
    
    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);
}