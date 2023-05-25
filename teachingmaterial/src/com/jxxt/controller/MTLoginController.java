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
import com.jxxt.entity.TAdmin;
import com.jxxt.entity.TLogin;
import com.jxxt.entity.TStudent;
import com.jxxt.entity.TTeacher;
import com.jxxt.mapper.TAdminMapper;
import com.jxxt.mapper.TNoticeMapper;
import com.jxxt.mapper.TStudentMapper;
import com.jxxt.mapper.TTeacherMapper;



@Controller
@RequestMapping ( "/login" )
public class MTLoginController extends Tools{
    /**
     * 日志系统
     */
	

    @Autowired
    TAdminMapper tAdminMapper;

    @Autowired
    TStudentMapper tStudentMapper;

    @Autowired
    TTeacherMapper tTeacherMapper;

    @Autowired
    TNoticeMapper tNoticeMapper;
    
	
	
	
	
	@ResponseBody
    @RequestMapping(value="login")
	public Map<String, Object>   adminLogin(TLogin tuser,HttpSession session,HttpServletRequest request){
		Map<String, Object> map = new HashMap<String,Object>();
		if("3".equals(tuser.getRole())) {
			//TUser user=tUserService.selectByAccount(tuser);
			TAdmin tAdmin  = tAdminMapper.selectAdminLogin(tuser.getUsername());
			if(tAdmin!=null) {
				if(tAdmin.getPassword().equals(tuser.getPassword())) {
					tuser.setId(tAdmin.getId());
					session.setAttribute("user", tuser);
					map.put("isFlag", 0);
				}else {
					map.put("isFlag", 1);
				}
			}else {
				map.put("isFlag", 2);
			}
		}
		if("1".equals(tuser.getRole())) {
			TStudent tStudent = tStudentMapper.selectStuLogin(tuser.getUsername());
			if(tStudent !=null) {
				if(tStudent.getStuPwd().equals(tuser.getPassword())) {
					tuser.setId(tStudent.getId());
					session.setAttribute("user", tuser);
					map.put("isFlag", 0);
				}else {
					map.put("isFlag", 1);
				}
			}else {
				map.put("isFlag", 2);
			}
			
		}
		if("2".equals(tuser.getRole())) {
			TTeacher tTeacher =tTeacherMapper.selectTeaLogin(tuser.getUsername());
			if(tTeacher!=null) {
				if(tTeacher.getTeaPwd().equals(tuser.getPassword())) {
					tuser.setId(tTeacher.getId());
					tuser.setProfessionId(tTeacher.getProfessionId());
					session.setAttribute("user", tuser);
					map.put("isFlag", 0);
				}else {
					map.put("isFlag", 1);
					
				}
			}else {
				map.put("isFlag", 2);
			}
			
		}
    	/*
		if(user != null){
			if(tuser.getPassword().equals(user.getPassword())){
				session.setAttribute("user", user);
 				return "main";
			}else{
				request.setAttribute("error_password", "密码错误！");
			}
		}else{
			request.setAttribute("error_username", "用户名不存在！");
		}*/
		return map;
	}
	
    @RequestMapping(value="main")
   	public String getMainPage(TLogin tuser,HttpSession session,HttpServletRequest request){
   		
       	/*TUser user=tUserService.selectByAccount(tuser);
   		if(user != null){
   			if(tuser.getPassword().equals(user.getPassword())){
   				session.setAttribute("user", user);
    				return "main";
   			}else{
   				request.setAttribute("error_password", "密码错误！");
   			}
   		}else{
   			request.setAttribute("error_username", "用户名不存在！");
   		}*/
   		return "main";
   	}

    
	@RequestMapping(value="editPassword")
	public Map<String,Object> editPassword(String password,HttpSession session){
		TLogin login = 	(TLogin) session.getAttribute("user");
		int i =0;
		if("1".equals(login.getRole())) { //学生
			TStudent ts = new TStudent();
			ts.setId(login.getId());
			ts.setStuPwd(password);
			i =tStudentMapper.updateByPrimaryKeySelective(ts);
		}
		if("2".equals(login.getRole())) {//老师
			TTeacher te = new TTeacher();
			te.setId(login.getId());
			te.setTeaPwd(password);
			i =tTeacherMapper.updateByPrimaryKeySelective(te);
		}
		if("3".equals(login.getRole())) {//管理员
			TAdmin ta = new TAdmin();
			ta.setId(login.getId());
			ta.setPassword(password);
			i =tAdminMapper.updateByPrimaryKeySelective(ta);
		}
		Map<String,Object> returnMap = new HashMap<String,Object>();
        if (i == 0)
        	returnMap.put("showInfo", "修改失败！");
        else
        	returnMap.put("showInfo", "修改成功！");
        return returnMap;
	}
    
	@RequestMapping(value="logout")
	public ModelAndView loginoutAdmin(HttpSession session){
		ModelAndView mv = new ModelAndView("index");
		List list = tNoticeMapper.findNotice();
		
		mv.addObject("list",list);
		
		session.removeAttribute("user");
		return mv;
	}
	
	
	@RequestMapping(value="index")
	public String index(HttpSession session){
		
		return "index";
	}
	@RequestMapping(value="home")
	public ModelAndView home(HttpSession session){
		TLogin login = 	(TLogin) session.getAttribute("user");
		ModelAndView mv = null;
		
		if("3".equals(login.getRole())) {
			mv= new ModelAndView("home");
			mv.addObject("studentCount", tStudentMapper.selectCount());
			mv.addObject("teacherCount", tTeacherMapper.selectCount());
		}else {
			mv= new ModelAndView("tea_home");
		}
		
		
		return mv;
	}
	
	
	
	
   /* private Log logger = LogFactory.getLog(MTUserController.class);

    @Autowired
    TUserMapper tUserService;

    @RequestMapping(value="getTUserPage")
    public ModelAndView getWorkInfoPage(HttpSession session, HttpServletRequest request) {
        logger.debug("MTUserController list begin");

        ModelAndView mv = new ModelAndView("mng/mg/tUser");
        return mv;
    }
    

    @RequestMapping(value="getTUserInfoPage")
    public ModelAndView getTUserInfoPage(HttpSession session, HttpServletRequest request) {
        logger.debug("MTUserController list begin");
       TUser user =  (TUser) session.getAttribute("user");
        ModelAndView mv = new ModelAndView("info");
        mv.addObject("info",user);
        return mv;
    }
    
    @RequestMapping(value="getAdminPage")
    public ModelAndView getAdminPage(HttpSession session, HttpServletRequest request) {
        logger.debug("MTUserController list begin");

        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }

    @RequestMapping(value="getUserPage")
    public ModelAndView getStudentPage(HttpSession session, HttpServletRequest request) {
        logger.debug("MTUserController list begin");

        ModelAndView mv = new ModelAndView("user");
        return mv;
    }

   
    
    @RequestMapping(value="index")
    public ModelAndView index(HttpSession session, HttpServletRequest request) {
        logger.debug("MTUserController list begin");

        ModelAndView mv = new ModelAndView("login/index");
        return mv;
    }

    @RequestMapping(value="registerPage")
    public ModelAndView registerPage(HttpSession session, HttpServletRequest request) {
        logger.debug("MTUserController list begin");

        ModelAndView mv = new ModelAndView("login/register");
        return mv;
    }

    
    
    
    
    @ResponseBody
    @RequestMapping(value= "/addAdmin")
    public String addTUser(TUser cus) {
    	SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
    	
    	cus.setAccount("t"+sdf.format(new Date()));
    	cus.setPassword("123456");
    	cus.setRole(2);
        int i = tUserService.insertSelective(cus);

        if (i == 0)
            return "添加失败！";
        else
            return "添加成功！";
    }
    
    @RequestMapping(value= "/addStudent")
    public ModelAndView addStudent(TUser cus) {
    	
    	
        int i = tUserService.insertSelective(cus);

        ModelAndView mv = new ModelAndView("login/index");
        return mv;
    }
    
    
    

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/queryTUserAll")
    public void queryTUserAll( int page ,int rows,int role ,HttpServletResponse response){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("role", role);
		map.put("number", (page-1)*rows);
		map.put("limit", rows);
		List<TUser> list=tUserService.selectPage(map);
		int count=tUserService.selectPageCount(map);
		Map<String,Object> m = new HashMap<String,Object>();
		m.put("rows", list);
		m.put("total", count);
		super.printJsonToPage(m ,response );
	}


   

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "editTUser")
    public String editTUser(TUser cus) {
    
        int i = tUserService.updateByPrimaryKeySelective(cus);
        if (i == 0)
            return "修改失败！";
        else
            return "修改成功！";

    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/deleteTUser")
    public String deleteTUser(TUser cus) {
        int i = tUserService.deleteByPrimaryKey(cus.getId());

        if (i == 0)
            return "删除失败！";
        else
            return "删除成功！";

    }
    
    
    @RequestMapping(value="login")
	public String adminLogin(TUser tuser,HttpSession session,HttpServletRequest request){
		
    	TUser user=tUserService.selectByAccount(tuser);
		if(user != null){
			if(tuser.getPassword().equals(user.getPassword())){
				session.setAttribute("user", user);
 				return "main";
			}else{
				request.setAttribute("error_password", "密码错误！");
			}
		}else{
			request.setAttribute("error_username", "用户名不存在！");
		}
		return "login/index";
	}
	
	@RequestMapping(value="loginout")
	public String loginoutAdmin(HttpSession session){
		
		session.removeAttribute("user");
		return "login/index";
	}
	

	
	
    @ResponseBody
    @RequestMapping(value= "/selecUserAll")
    public void selectAll(HttpServletResponse response) {
    	List<TUser> list = tUserService.selectAll();
    	printJsonToPage(list, response);
    }*/

	
}
