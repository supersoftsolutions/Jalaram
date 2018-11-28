package com.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.Add_wholesale_client_DAO;
import com.DAO.Retail_client_DAO;
import com.VO.Add_wholesale_client_VO;
import com.VO.LoginVO;
import com.VO.Retail_client_VO;

@Controller
public class Retail_client {
	
	@Autowired
	Retail_client_DAO dao;

	@RequestMapping(value="Add_retail_client.html",method=RequestMethod.GET)
	public ModelAndView index12()
	{
		return new ModelAndView("Admin/Add_retail_client","data",new Add_wholesale_client_VO());
	}
	
	@RequestMapping(value="add_retail_client.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Retail_client_VO  vo,HttpSession session)
	{
		this.dao.insert(vo);
		
		return new ModelAndView("redirect:Add_retail_client.html");
	}
}
