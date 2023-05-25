package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TRoom;

public interface TRoomMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TRoom record);

    int insertSelective(TRoom record);

    TRoom selectByPrimaryKey(Integer id);

    List findPage(Page page);

    List findRoom();
    
    int updateByPrimaryKeySelective(TRoom record);

    int updateByPrimaryKey(TRoom record);
}