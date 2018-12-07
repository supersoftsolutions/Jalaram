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

import com.DAO.Retail_client_DAO;
import com.DAO.Sun_mon_product_DAO;
import com.VO.Product_mon_retail_VO;
import com.VO.Retail_product_VO;
import com.VO.Wholesale_product_VO;

@Controller


public class Retail_product {
	
	@Autowired
	Retail_client_DAO dao;
	@Autowired
	Sun_mon_product_DAO sdao;


	@RequestMapping(value="Add_retail_product.html",method=RequestMethod.GET)
	public ModelAndView index1()
	{
		List ls=dao.search1();
		return new ModelAndView("Admin/Add_retail_product","data",new Retail_product_VO()).addObject("list",ls);
	}
	
	@RequestMapping(value="insert_retail_product.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Retail_product_VO  vo,HttpSession session)
	{
		Product_mon_retail_VO mvo=new Product_mon_retail_VO();
		this.dao.product(vo);
		this.sdao.edit(mvo, vo);
		
		return new ModelAndView("redirect:Add_retail_product.html");
	}
	
	@RequestMapping(value="View_retail_product.html",method=RequestMethod.GET)
	public ModelAndView search()
	{
		List ls=dao.search();
		return new ModelAndView("Admin/View_retail_product","list",ls);
	}
	
	@RequestMapping(value="delete_retail_product.html",method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, Retail_product_VO  vo)
	{
		vo.setProductid(id);
		dao.delete(vo);
		return new ModelAndView("redirect:View_retail_product.html");

	}
	
	@RequestMapping(value="edit_retail_product.html",method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id, Retail_product_VO  vo)
	{
		
		List ls1=dao.search1();
		vo.setProductid(id);
		List ls=dao.edit(vo);
		return new ModelAndView("Admin/Edit_retail_product","data",( Retail_product_VO)ls.get(0)).addObject("list",ls1);
	}
	
	@RequestMapping(value="update_retail_product.html",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute  Retail_product_VO vo)
	{
		dao.update1(vo);
		return new ModelAndView("redirect:View_retail_product.html");
		
	}
	
	

}
