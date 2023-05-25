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
import com.jxxt.entity.TReceive;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TBookMapper;
import com.jxxt.mapper.TInventoryMapper;
import com.jxxt.mapper.TReceiveMapper;
import com.jxxt.mapper.TStudentMapper;



@Controller
@RequestMapping ( "/receive" )
public class TReceiveController extends Tools{
  
    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TReceiveMapper tReceiveMapper;
    @Autowired
    TInventoryMapper tInventoryMapper;
    
    @Autowired
    TBookMapper tBookMapper;
	
    @RequestMapping(value="receiveHtml")
   	public ModelAndView getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("admin_receive");
   		return mv;
   	}
    
    @RequestMapping(value="receiveStuHtml")
   	public ModelAndView receiveStuHtml(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("stu_receive");
   		return mv;
   	}
    @RequestMapping(value="receiveteaHtml")
   	public ModelAndView receiveteaHtml(TLogin tuser,HttpSession session,HttpServletRequest request){
    	ModelAndView mv = new ModelAndView("tea_receive");
   		return mv;
   	}
/*    @ResponseBody
    @RequestMapping(value= "/findReceive")
    public List findReceive() {
    	List list = tReceiveMapper.findReceive();
        return list;
    }*/
    
    @ResponseBody
    @RequestMapping(value= "/query")
    public Page findReceivePage( Page page , TReceive receive) throws UnsupportedEncodingException {
    	String  str = new String(receive.getBook().getBytes("ISO8859_1"), "utf-8");
    	receive.setBook(str);
    	page.setSearchParam(receive);
    	tReceiveMapper.findPage(page);
        return page;
    }
    @ResponseBody
    @RequestMapping(value= "/teaQuery")
    public Page teaQuery( Page page , TReceive receive,HttpSession session) throws UnsupportedEncodingException {
    	String  str = new String(receive.getBook().getBytes("ISO8859_1"), "utf-8");
    	receive.setBook(str);
    	TLogin login = (TLogin) session.getAttribute("user");
    	receive.setUserId(login.getId());
    	page.setSearchParam(receive);
    	tReceiveMapper.findTeaPage(page);
        return page;
    }
    @ResponseBody
    @RequestMapping(value= "/stuQuery")
    public Page StuQuery( Page page , TReceive receive,HttpSession session) throws UnsupportedEncodingException {
    	String  str = new String(receive.getBook().getBytes("ISO8859_1"), "utf-8");
    	receive.setBook(str);
    	TLogin login = (TLogin) session.getAttribute("user");
    	receive.setUserId(login.getId());
    	page.setSearchParam(receive);
    	tReceiveMapper.findStuPage(page);
        return page;
    }
    
    @ResponseBody
    @RequestMapping(value= "/insertReceive")
    public Map<String,Object> addTUser(TReceive receive,HttpSession session) {
    	
    	TLogin login = (TLogin) session.getAttribute("user");
    	receive.setBookId(receive.getId());
    	receive.setUserId(login.getId());
    	receive.setRolId(Integer.parseInt(login.getRole()));
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	receive.setCreateTime(sdf.format(new Date()));
    	receive.setStatus("1");
    	
    	TBook bo= tBookMapper.selectByPrimaryKey(receive.getId());  //减掉数量
		TBook book = new TBook();
		book.setId(receive.getId());
		book.setNum((Integer.parseInt(bo.getNum())-Integer.parseInt(receive.getAmount()))+"");
		tBookMapper.updateByPrimaryKeySelective(book);
    	
    	int i =tReceiveMapper.insertSelective(receive);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "领用失败！");
        else
        	returnMap.put("showInfo", "领用成功！");
        return returnMap;
    }
    
    
    @ResponseBody
    @RequestMapping(value= "/updateReceive")
    public Map<String,Object> updateReceive(Integer id ,String status) {
    	TReceive rece = tReceiveMapper.selectByPrimaryKey(id);
    	TBook bo= tBookMapper.selectByPrimaryKey(rece.getBookId());  //减掉数量
    	if(status.equals("2")) {
    		TInventory tInventory = new TInventory();
    		tInventory.setBookId(rece.getBookId());
    		tInventory.setNum(rece.getAmount());
    		tInventory.setRolId(rece.getRolId()+"");
    		tInventory.setUserId(rece.getUserId());
    		tInventory.setStatus("出库");
    		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    		tInventory.setCreateTime(sdf.format(new Date()));
    		tInventory.setInvent(bo.getNum());
    		tInventoryMapper.insertSelective(tInventory);//添加库存
    		
    		/*TBook bo= tBookMapper.selectByPrimaryKey(rece.getBookId());  //减掉数量
    		TBook book = new TBook();
    		book.setId(rece.getBookId());
    		book.setNum((Integer.parseInt(bo.getNum())-Integer.parseInt(rece.getAmount()))+"");
    		tBookMapper.updateByPrimaryKey(bo);*/
    		
    	}
    	if(status.equals("3")) {
    		TBook book = new TBook();
    		book.setId(rece.getBookId());
    		book.setNum((Integer.parseInt(bo.getNum())+Integer.parseInt(rece.getAmount()))+"");
    		tBookMapper.updateByPrimaryKeySelective(book);
    	}
    	
    	TReceive receive = new TReceive();
    	receive.setId(id);
    	receive.setStatus(status);
    	int i =tReceiveMapper.updateByPrimaryKeySelective(receive);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "审核失败！");
        else
        	returnMap.put("showInfo", "审核成功！");
        return returnMap;
    }
    
    @ResponseBody
    @RequestMapping(value= "/deleteReceive")
    public Map<String,Object> deleteReceive(int id) {
    	int i =tReceiveMapper.deleteByPrimaryKey(id);
    	Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "删除失败！");
        else
        	returnMap.put("showInfo", "删除成功！");
        return returnMap;
    }
    
    

}
