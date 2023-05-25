package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TReceive;

public interface TReceiveMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TReceive record);

    int insertSelective(TReceive record);

    List findPage(Page page);
    List findStuPage(Page page);
    List findTeaPage(Page page);
    TReceive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TReceive record);

    int updateByPrimaryKey(TReceive record);
}