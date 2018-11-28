package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.Add_wholesale_client_DAO;
import com.VO.Add_wholesale_client_VO;


public class Add_wholesale_client_controller {
	
	@Autowired
	Add_wholesale_client_DAO dao;
	
	
	@RequestMapping(value="add_wholesale_client.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Add_wholesale_client_VO vo)
	{
		this.dao.insert(vo);
		
				
		
		
		return new ModelAndView("redirect:Add_wholesale_client.html");
	}

}
