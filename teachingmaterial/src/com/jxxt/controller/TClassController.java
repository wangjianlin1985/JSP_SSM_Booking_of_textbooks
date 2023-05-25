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
import com.jxxt.entity.TClass;
import com.jxxt.entity.TLogin;
import com.jxxt.mapper.TClassMapper;



@Controller
@RequestMapping ( "/tClass" )
public class TClassController extends Tools{
  

    @Autowired
    TClassMapper tTClassMapper;

	
	
    @RequestMapping(value="classHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("class");
   		return mv;
   	}
   	
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTClassPage( Page page , TClass tClass) {
    	page.setSearchParam(tClass);
    	tTClassMapper.findPage(page);
        return page;
    }
    
    @ResponseBody
    @RequestMapping(value= "/findClass")
    public List findTClassPage() {
    	List list = tTClassMapper.findClass();
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/insertTClass")
    public Map<String,Object> addTUser(TClass tClass) {
    	int i =tTClassMapper.insertSelective(tClass);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTClass")
    public Map<String,Object> updateTClass(TClass tClass) {
    	int i =tTClassMapper.updateByPrimaryKeySelective(tClass);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTClass")
    public Map<String,Object> deleteTClass(int id) {
    	int i =tTClassMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
