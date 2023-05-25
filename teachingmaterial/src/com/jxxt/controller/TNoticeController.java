package com.jxxt.controller;

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
import com.jxxt.entity.TNotice;
import com.jxxt.mapper.TNoticeMapper;



@Controller
@RequestMapping ( "/notice" )
public class TNoticeController extends Tools{
  

    @Autowired
    TNoticeMapper tNoticeMapper;

	
	
    @RequestMapping(value="noticeHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("notice");
   		return mv;
   	}
   	
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findNoticePage( Page page , TNotice notice) {
    	page.setSearchParam(notice);
    	tNoticeMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertNotice")
    public Map<String,Object> addTUser(TNotice notice) {
    	int i =tNoticeMapper.insertSelective(notice);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateNotice")
    public Map<String,Object> updateNotice(TNotice notice) {
    	int i =tNoticeMapper.updateByPrimaryKeySelective(notice);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteNotice")
    public Map<String,Object> deleteNotice(int id) {
    	int i =tNoticeMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
