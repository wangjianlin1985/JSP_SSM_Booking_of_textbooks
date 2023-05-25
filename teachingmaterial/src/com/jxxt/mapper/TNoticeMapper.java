package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TNotice;

public interface TNoticeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TNotice record);

    int insertSelective(TNotice record);

    TNotice selectByPrimaryKey(Integer id);

    List findPage(Page page);
    List findNotice();
    
    int updateByPrimaryKeySelective(TNotice record);

    int updateByPrimaryKey(TNotice record);
}