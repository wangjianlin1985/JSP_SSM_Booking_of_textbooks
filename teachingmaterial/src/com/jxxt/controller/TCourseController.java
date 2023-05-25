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
import com.jxxt.entity.TCourse;
import com.jxxt.entity.TLogin;
import com.jxxt.mapper.TCourseMapper;



@Controller
@RequestMapping ( "/course" )
public class TCourseController extends Tools{
  

    @Autowired
    TCourseMapper tCourseMapper;

	
	
    @RequestMapping(value="courseHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("course");
   		return mv;
   	}
   	
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findCoursePage( Page page , TCourse course) {
    	page.setSearchParam(course);
    	tCourseMapper.findPage(page);
        return page;
    }
    
    @ResponseBody
    @RequestMapping(value= "/findCourse")
    public List findCourse() {
    	List list = tCourseMapper.findCourse();
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/insertCourse")
    public Map<String,Object> addTUser(TCourse course) {
    	int i =tCourseMapper.insertSelective(course);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateCourse")
    public Map<String,Object> updateCourse(TCourse course) {
    	int i =tCourseMapper.updateByPrimaryKeySelective(course);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteCourse")
    public Map<String,Object> deleteCourse(int id) {
    	int i =tCourseMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
