package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TMenus;

public interface TMenusMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TMenus record);

    int insertSelective(TMenus record);

    TMenus selectByPrimaryKey(Integer id);

    List findPage(Page page);

    
    int updateByPrimaryKeySelective(TMenus record);

    int updateByPrimaryKey(TMenus record);
    
    /**
     * 根据父Id查询 一级菜单
     * @param pid
     * @return
     */
    List<TMenus> findByPid(Integer pid);
}