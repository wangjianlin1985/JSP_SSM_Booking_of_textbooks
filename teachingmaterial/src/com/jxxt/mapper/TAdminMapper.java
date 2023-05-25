package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TAdmin;

public interface TAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    TAdmin selectByPrimaryKey(Integer id);
    
    List findPage(Page page);
    
    TAdmin selectAdminLogin(String username);

    int updateByPrimaryKeySelective(TAdmin record);

    int updateByPrimaryKey(TAdmin record);
}