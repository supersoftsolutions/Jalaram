package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.Add_wholesale_client_DAO;
import com.DAO.Retail_client_DAO;
import com.VO.Retail_product_VO;
import com.VO.Wholesale_product_VO;

@Controller
public class Retail_product {
	
	@Autowired
	Retail_client_DAO dao;


	@RequestMapping(value="Add_retail_product.html",method=RequestMethod.GET)
	public ModelAndView index1()
	{
		List ls=dao.search1();
		return new ModelAndView("Admin/Add_retail_product","data",new Retail_product_VO()).addObject("list",ls);
	}
	
	@RequestMapping(value="insert_retail_product.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Retail_product_VO  vo,HttpSession session)
	{
		this.dao.product(vo);
		
		return new ModelAndView("redirect:Add_retail_product.html");
	}
	
}
