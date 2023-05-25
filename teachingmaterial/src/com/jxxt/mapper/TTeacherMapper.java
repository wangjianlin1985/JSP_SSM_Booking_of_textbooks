package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TStudent;
import com.jxxt.entity.TTeacher;

public interface TTeacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TTeacher record);

    int insertSelective(TTeacher record);

    TTeacher selectByPrimaryKey(Integer id);
  
    List findPage(Page page);

    int selectCount();
    
    TTeacher selectTeaLogin(String teaNo);

    int updateByPrimaryKeySelective(TTeacher record);

    int updateByPrimaryKey(TTeacher record);
}