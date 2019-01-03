package com.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.Add_wholesale_client_DAO;
import com.VO.Add_wholesale_client_VO;
import com.VO.LoginVO;
import com.DAO.LoginDAO;


@Controller
public class MainController {

	
	
	@Autowired
	LoginDAO ldao;
	
	
	
	@RequestMapping(value = { "/", "index.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		return new ModelAndView("Admin/Login");
		
	}
	            
	@RequestMapping(value = "/admin.html", method = RequestMethod.GET)
	public String admin(HttpSession session,Model model) {
		
		/*List pls = 	this.ldao.serchProduct();	
	    session.setAttribute("pList", pls.size());
	    
	    List cls = 	this.ldao.serchclient();	
	    session.setAttribute("cList", pls.size());*/
	
		return "Admin/Welcome";
	}
	
	
	
	
	

	@RequestMapping(value = "/user.html", method = RequestMethod.GET)
	public String user(HttpSession session,Model model) {
		
		return "User/Welcome";
	}
	@RequestMapping(value = "/403page.html", method = RequestMethod.GET)
	public String AccessDenied(HttpSession session,Model model) {
		
		return "Admin/Login";
	}
	
	@RequestMapping(value="/j_spring_security_logout" , method=RequestMethod.GET)
	public String logout(Model model){
		System.out.println("*****Successfully Loggedout******");
		return("Admin/Login");
	}
	
}



