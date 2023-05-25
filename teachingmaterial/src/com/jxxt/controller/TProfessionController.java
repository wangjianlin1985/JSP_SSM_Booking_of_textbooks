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
import com.jxxt.entity.TProfession;
import com.jxxt.mapper.TProfessionMapper;



@Controller
@RequestMapping ( "/profession" )
public class TProfessionController extends Tools{
  

    @Autowired
    TProfessionMapper tProfessionMapper;

	
	
    @RequestMapping(value="professionHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("profession");
   		return mv;
   	}
   	
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findProfessionPage( Page page , TProfession profession) {
    	page.setSearchParam(profession);
    	tProfessionMapper.findPage(page);
        return page;
    }
    
    
    
    @ResponseBody
    @RequestMapping(value= "/findProfession")
    public List findProfession() {
    	List list = tProfessionMapper.findProfession();
        return list;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertProfession")
    public Map<String,Object> addTUser(TProfession profession) {
    	int i =tProfessionMapper.insertSelective(profession);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateProfession")
    public Map<String,Object> updateProfession(TProfession profession) {
    	int i =tProfessionMapper.updateByPrimaryKeySelective(profession);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteProfession")
    public Map<String,Object> deleteProfession(int id) {
    	int i =tProfessionMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
