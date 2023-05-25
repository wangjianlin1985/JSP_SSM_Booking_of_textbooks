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

import com.jxxt.controller.tools.Tools;
import com.jxxt.entity.TLogin;
import com.jxxt.entity.TScore;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TScoreMapper;
import com.jxxt.mapper.TStudentMapper;



@Controller
@RequestMapping ( "/score" )
public class TScoreController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TScoreMapper tScoreMapper;

	
	
    @RequestMapping(value="stu_scoreHtml")
   	public ModelAndView stu_scoreHtml(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("stu_score");
   		return mv;
   	}
    @RequestMapping(value="tea_scoreHtml")
   	public ModelAndView tea_scoreHtml(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("tea_score");
   		return mv;
   	}
    
 /*   @ResponseBody
    @RequestMapping(value= "/query")
    public Page findScorePage( Page page , TScore score) {
    	page.setSearchParam(score);
    	tScoreMapper.findPage(page);
        return page;
    }
    */
    @ResponseBody
    @RequestMapping(value= "/findScore")
    public List findScore(int stuId) {
    	List list = tScoreMapper.findScore(stuId);
        return list;
    }
    
    
    
    @ResponseBody
    @RequestMapping(value= "/validateScore")
    public int validateScore(TScore score) {
    	int i  = tScoreMapper.validateScore(score);
        return i;
    }
    
    
    
    @ResponseBody
    @RequestMapping(value= "/insertScore")
    public Map<String,Object> addTUser(TScore score,HttpSession session) {
    	
    	TLogin login = 	(TLogin) session.getAttribute("user");
    	score.setTeaId(login.getId());
    	int i =tScoreMapper.insertSelective(score);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateScore")
    public Map<String,Object> updateScore(TScore score) {
    	int i =tScoreMapper.updateByPrimaryKeySelective(score);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteScore")
    public Map<String,Object> deleteScore(int id) {
    	int i =tScoreMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
