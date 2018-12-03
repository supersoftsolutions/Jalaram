package com.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.Add_wholesale_client_DAO;

import com.VO.Wholesale_product_VO;

@Controller

public class Wholesale_product {
	
	@Autowired
	Add_wholesale_client_DAO dao;


	@RequestMapping(value="Add_wholesale_product.html",method=RequestMethod.GET)
	public ModelAndView index1()
	{
		List ls=dao.search1();
		return new ModelAndView("Admin/Add_wholesale_product","data",new Wholesale_product_VO()).addObject("list",ls);
	}
	
	@RequestMapping(value="insert_wholesale_product.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Wholesale_product_VO  vo,HttpSession session)
	{
		this.dao.product(vo);
		
		return new ModelAndView("redirect:Add_wholesale_product.html");
	}
	
}
