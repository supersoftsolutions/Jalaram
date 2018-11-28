package com.controller;

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

@Controller
public class MainController {

	@Autowired
	Add_wholesale_client_DAO dao;
	
	@RequestMapping(value = { "/", "index.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("Admin/Login");
	}
	            
	@RequestMapping(value = "/admin.html", method = RequestMethod.GET)
	public String admin(HttpSession session,Model model) {
		
		return "Admin/Welcome";
	}
	
	/*@RequestMapping(value="Add_wholesale_client.html",method=RequestMethod.GET)
	public ModelAndView index1()
	{
		return new ModelAndView("Admin/Add_wholesale_client","data",new Add_wholesale_client_VO());
	}
	
	@RequestMapping(value="add_wholesale_client.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Add_wholesale_client_VO  vo)
	{
		this.dao.insert(vo);
		
				
		
		
		return new ModelAndView("redirect:Add_wholesale_client.html");
	}*/

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
