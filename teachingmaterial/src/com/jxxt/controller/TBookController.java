package com.jxxt.controller;

import java.io.UnsupportedEncodingException;
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
import com.jxxt.entity.TBook;
import com.jxxt.entity.TInventory;
import com.jxxt.entity.TLogin;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TBookMapper;
import com.jxxt.mapper.TInventoryMapper;
import com.jxxt.mapper.TStudentMapper;



@Controller
@RequestMapping ( "/book" )
public class TBookController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TBookMapper tBookMapper;

    @Autowired
    TInventoryMapper tInventoryMapper;
	
	
    @RequestMapping(value="bookHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("book");
   		return mv;
   	}
    
    @RequestMapping(value="stuBookHtml")
   	public ModelAndView stuBookHtml(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("stu_book");
   		return mv;
   	}
  
  
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findBookPage( Page page , TBook book) throws UnsupportedEncodingException {
    	String  str = new String(book.getBook().getBytes("ISO8859_1"), "utf-8");
    	book.setBook(str);
    	page.setSearchParam(book);
    	tBookMapper.findPage(page);
        return page;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/insertBook")
    public Map<String,Object> addTUser(TBook book,HttpSession session) {
    	TLogin login = (TLogin) session.getAttribute("user");
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	int i =tBookMapper.insertSelective(book);
    	TInventory ti = new TInventory();
    	ti.setBookId(book.getId());
    	ti.setNum(book.getNum());
    	ti.setRolId(login.getRole());
    	ti.setUserId(login.getId());
    	ti.setCreateTime(sdf.format(new Date()));
    	ti.setStatus("入库");
    	ti.setInvent(book.getNum());
    	tInventoryMapper.insertSelective(ti);
    	
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "添加失败！");
        else
        	returnMap.put("showInfo", "添加成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateBook")
    public Map<String,Object> updateBook(TBook book) {
    	int i =tBookMapper.updateByPrimaryKeySelective(book);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteBook")
    public Map<String,Object> deleteBook(int id) {
    	int i =tBookMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
