package com.jxxt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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
import com.jxxt.entity.TStudent;
import com.jxxt.mapper.TStudentMapper;



@Controller
@RequestMapping ( "/student" )
public class TStudentController extends Tools{

    @Autowired
    TStudentMapper tStudentMapper;

   

	
	
    @RequestMapping(value="studentHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("student");
   		return mv;
   	}
    @RequestMapping(value="tea_studentHtml")
   	public ModelAndView tea_studentHtml(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("tea_student");
   		return mv;
   	}
    
    
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findStudentPage( Page page , TStudent student) {
    	page.setSearchParam(student);
    	tStudentMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertStudent")
    public Map<String,Object> addTUser(TStudent student) {
    	SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
    	String stuno = sdf.format(new Date());
    	//student.setStuNo(stuno);
    	student.setStuPwd("123456");
    	int i =tStudentMapper.insertSelective(student);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateStudent")
    public Map<String,Object> updateStudent(TStudent student) {
    	int i =tStudentMapper.updateByPrimaryKeySelective(student);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteStudent")
    public Map<String,Object> deleteStudent(int id) {
    	int i =tStudentMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
