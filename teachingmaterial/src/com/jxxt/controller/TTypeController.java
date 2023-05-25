package com.jxxt.controller;

import java.io.UnsupportedEncodingException;
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
import com.jxxt.entity.TType;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TTypeMapper;
import com.jxxt.mapper.TStudentMapper;



@Controller
@RequestMapping ( "/type" )
public class TTypeController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TTypeMapper tTypeMapper;

	
	
    @RequestMapping(value="typeHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("type");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findType")
    public List findType() {
    	List list = tTypeMapper.findType();
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTypePage( Page page , TType type) throws UnsupportedEncodingException {
    	String  str = new String(type.getTypeName().getBytes("ISO8859_1"), "utf-8");
    	type.setTypeName(str);
    	page.setSearchParam(type);
    	tTypeMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertType")
    public Map<String,Object> addTUser(TType type) {
    	int i =tTypeMapper.insertSelective(type);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateType")
    public Map<String,Object> updateType(TType type) {
    	int i =tTypeMapper.updateByPrimaryKeySelective(type);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteType")
    public Map<String,Object> deleteType(int id) {
    	int i =tTypeMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
