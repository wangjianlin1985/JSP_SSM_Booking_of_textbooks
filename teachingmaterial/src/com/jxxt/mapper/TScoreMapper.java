package com.jxxt.mapper;

import java.util.List;

import com.jxxt.entity.TScore;

public interface TScoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TScore record);

    int insertSelective(TScore record);

    TScore selectByPrimaryKey(Integer id);

    List findScore(int stuId);
    
    int validateScore(TScore record);
    
    
    int updateByPrimaryKeySelective(TScore record);

    int updateByPrimaryKey(TScore record);
}