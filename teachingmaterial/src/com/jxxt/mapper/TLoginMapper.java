package com.jxxt.mapper;

import com.jxxt.entity.TLogin;

public interface TLoginMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TLogin record);

    int insertSelective(TLogin record);

    TLogin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TLogin record);

    int updateByPrimaryKey(TLogin record);
}