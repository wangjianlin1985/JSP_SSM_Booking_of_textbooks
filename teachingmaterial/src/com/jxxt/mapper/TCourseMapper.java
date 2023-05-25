package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TCourse;

public interface TCourseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TCourse record);

    int insertSelective(TCourse record);

    TCourse selectByPrimaryKey(Integer id);

    List findPage(Page page);

    List findCourse();
    int updateByPrimaryKeySelective(TCourse record);

    int updateByPrimaryKey(TCourse record);
}