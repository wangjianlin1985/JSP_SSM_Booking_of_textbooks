package com.jxxt.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jxxt.common.pojo.Page;
import com.jxxt.controller.tools.Tools;
import com.jxxt.entity.TLogin;
import com.jxxt.entity.TInventory;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TInventoryMapper;
import com.jxxt.mapper.TStudentMapper;



@Controller
@RequestMapping ( "/inventory" )
public class TInventoryController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TInventoryMapper tInventoryMapper;

	
	
    @RequestMapping(value="inventoryHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	
    	int outHe= tInventoryMapper.outHe();
    	int outNum = tInventoryMapper.outNum();
    	int inHe = tInventoryMapper.inHe();
    	int inNum =tInventoryMapper.inNum();
    	ModelAndView mv = new ModelAndView("inventory");
    	mv.addObject("outHe", outHe);
    	mv.addObject("outNum", outNum);
    	mv.addObject("inHe", inHe);
    	mv.addObject("inNum", inNum);
    	
   		return mv;
   	}
    
 /*   @ResponseBody
    @RequestMapping(value= "/findInventory")
    public List findInventory() {
    	List list = tInventoryMapper.findInventory();
        return list;
    }*/
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findInventoryPage( Page page , TInventory inventory) {
    	page.setSearchParam(inventory);
    	tInventoryMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertInventory")
    public Map<String,Object> addTUser(TInventory inventory) {
    	int i =tInventoryMapper.insertSelective(inventory);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateInventory")
    public Map<String,Object> updateInventory(TInventory inventory) {
    	int i =tInventoryMapper.updateByPrimaryKeySelective(inventory);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteInventory")
    public Map<String,Object> deleteInventory(int id) {
    	int i =tInventoryMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
