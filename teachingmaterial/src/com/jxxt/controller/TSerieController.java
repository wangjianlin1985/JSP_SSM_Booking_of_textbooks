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
import com.jxxt.entity.TSerie;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TSerieMapper;
import com.jxxt.mapper.TStudentMapper;



@Controller
@RequestMapping ( "/serie" )
public class TSerieController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TSerieMapper tSerieMapper;

	
	
    @RequestMapping(value="serieHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("serie");
   		return mv;
   	}
   	
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findSeriePage( Page page , TSerie serie) {
    	page.setSearchParam(serie);
    	tSerieMapper.findPage(page);
        return page;
    }
    
    @ResponseBody
    @RequestMapping(value= "/findSerie")
    public List findTClassPage() {
    	List list = tSerieMapper.findSerie();
        return list;
    }
    
    @ResponseBody
    @RequestMapping(value= "/insertSerie")
    public Map<String,Object> addTUser(TSerie serie) {
    	int i =tSerieMapper.insertSelective(serie);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateSerie")
    public Map<String,Object> updateSerie(TSerie serie) {
    	int i =tSerieMapper.updateByPrimaryKeySelective(serie);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteSerie")
    public Map<String,Object> deleteSerie(int id) {
    	int i =tSerieMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
