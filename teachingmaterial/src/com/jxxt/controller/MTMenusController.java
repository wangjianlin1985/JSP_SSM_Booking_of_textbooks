package com.jxxt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jxxt.controller.tools.Tools;
import com.jxxt.entity.TMenus;
import com.jxxt.mapper.TMenusMapper;



@Controller
@RequestMapping("/tMenus")
public class MTMenusController extends Tools{

    @Autowired
    TMenusMapper tMenusMapper;


    @ResponseBody
    @RequestMapping(method = RequestMethod.GET, value = "/findMenus")
    public List<TMenus> findAll() {
    	List<TMenus> plist = tMenusMapper.findByPid(0);
    	for (TMenus tMenus : plist) {
    		List<TMenus> clist = tMenusMapper.findByPid(tMenus.getId());
    		tMenus.setMenus(clist);
		}
    	return plist;
    }
    
    

}
