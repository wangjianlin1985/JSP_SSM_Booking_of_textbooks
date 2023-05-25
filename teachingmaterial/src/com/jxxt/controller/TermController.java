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
import com.jxxt.entity.TTerm;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TStudentMapper;
import com.jxxt.mapper.TTermMapper;



@Controller
@RequestMapping ( "/term" )
public class TermController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TTermMapper tTermMapper;

	
	
    @RequestMapping(value="termHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("term");
   		return mv;
   	}
   	
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTermPage( Page page , TTerm term) {
    	page.setSearchParam(term);
    	tTermMapper.findPage(page);
        return page;
    }
    
    @ResponseBody
    @RequestMapping(value= "/findTerm")
    public List findTerm() {
    	List list = tTermMapper.findTerm();
        return list;
    }
    
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTerm")
    public Map<String,Object> addTUser(TTerm term) {
    	int i =tTermMapper.insertSelective(term);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTerm")
    public Map<String,Object> updateTerm(TTerm term) {
    	int i =tTermMapper.updateByPrimaryKeySelective(term);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTerm")
    public Map<String,Object> deleteTerm(int id) {
    	int i =tTermMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
