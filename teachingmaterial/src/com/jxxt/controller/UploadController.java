package com.jxxt.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.jxxt.controller.tools.Tools;


public class UploadController extends Tools  {

	
	
	public String uploadManager(){
		
		return "upload";
	}
	
	
	
	public String  insertFileInfo(@RequestParam("files") CommonsMultipartFile[] files,HttpServletRequest request){
		
		
		System.out.println(123);
		 // 判断文件是否为空  
        if (!files[0].isEmpty()) {  
            try {  
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"+ files[0].getOriginalFilename();  
                System.out.println(filePath);
                // 转存文件  
                files[0].transferTo(new File(filePath));  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
		return "添加成功";
	}
	
}
