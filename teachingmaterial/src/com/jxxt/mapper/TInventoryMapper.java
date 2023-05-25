package com.jxxt.mapper;

import java.util.List;

import com.jxxt.common.pojo.Page;
import com.jxxt.entity.TInventory;

public interface TInventoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TInventory record);

    int insertSelective(TInventory record);
    
    List findPage(Page page);

    TInventory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TInventory record);

    int updateByPrimaryKey(TInventory record);
    
    int outNum();
    int outHe  (); 
    int inNum ();
    int inHe();
}