package com.jxxt.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.jxxt.entity.TTeacher;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TStudentMapper;
import com.jxxt.mapper.TTeacherMapper;



@Controller
@RequestMapping ( "/teacher" )
public class TeacherController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TTeacherMapper tTeacherMapper;

	
	
    @RequestMapping(value="teacherHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("teacher");
   		return mv;
   	}
   	
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findTeacherPage( Page page , TTeacher teacher) {
    	page.setSearchParam(teacher);
    	tTeacherMapper.findPage(page);
        return page;
    }
    
   /* @ResponseBody
    @RequestMapping(value= "/findTeacher")
    public List findTeacher() {
    	List list = tTeacherMapper.findTeacher();
        return list;
    }*/
    
    
    
    @ResponseBody
    @RequestMapping(value= "/insertTeacher")
    public Map<String,Object> addTUser(TTeacher teacher) {
    	SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
    	String stuno = sdf.format(new Date());
    	//teacher.setTeaNo(stuno);
    	teacher.setTeaPwd("123456");
    	int i =tTeacherMapper.insertSelective(teacher);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateTeacher")
    public Map<String,Object> updateTeacher(TTeacher teacher) {
    	int i =tTeacherMapper.updateByPrimaryKeySelective(teacher);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteTeacher")
    public Map<String,Object> deleteTeacher(int id) {
    	int i =tTeacherMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
