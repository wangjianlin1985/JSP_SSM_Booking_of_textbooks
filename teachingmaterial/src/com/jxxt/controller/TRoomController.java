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
import com.jxxt.entity.TRoom;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TRoomMapper;
import com.jxxt.mapper.TStudentMapper;



@Controller
@RequestMapping ( "/room" )
public class TRoomController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TRoomMapper tRoomMapper;

	
	
    @RequestMapping(value="roomHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("room");
   		return mv;
   	}
    
    @ResponseBody
    @RequestMapping(value= "/findRoom")
    public List findRoom() {
    	List list = tRoomMapper.findRoom();
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findRoomPage( Page page , TRoom room) {
    	page.setSearchParam(room);
    	tRoomMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertRoom")
    public Map<String,Object> addTUser(TRoom room) {
    	int i =tRoomMapper.insertSelective(room);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateRoom")
    public Map<String,Object> updateRoom(TRoom room) {
    	int i =tRoomMapper.updateByPrimaryKeySelective(room);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteRoom")
    public Map<String,Object> deleteRoom(int id) {
    	int i =tRoomMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
