package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		return new ModelAndView("Admin/Add_retail_client","data",new Retail_client_VO());
	}
	
	@RequestMapping(value="add_retail_client.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Retail_client_VO  vo,HttpSession session)
	{
		this.dao.insert(vo);
		
		return new ModelAndView("redirect:Add_retail_client.html");
	}
	
	@RequestMapping(value="View_retail_client.html",method=RequestMethod.GET)
	public ModelAndView index12(@ModelAttribute Retail_client_VO  vo)
	
	
	{
		
		List ls=dao.search1(vo);
		return new ModelAndView("Admin/View_retail_client","list",ls);
	}
	
	@RequestMapping(value="delete_retail.html",method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, Retail_client_VO  vo)
	{
			vo.setID(id);
			dao.delete(vo);
			return new ModelAndView("redirect:View_retail_client.html");
	}
	

	@RequestMapping(value="editretail_client.html",method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id, Retail_client_VO  vo)
	{
		vo.setID(id);
		List ls=dao.edit(vo);
		return new ModelAndView("Admin/Edit_retail_client","list",(Retail_client_VO)ls.get(0));
	}
	
	/*@RequestMapping(value="updateretail_client.html",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute Retail_client_VO  vo)
	{
		dao.update(vo);
		return new ModelAndView("redirect:View_retail_client.html");
		
	}
	*/
	
	@RequestMapping(value="updateretail_client.html",method=RequestMethod.POST)
	public ModelAndView update1(@ModelAttribute Retail_client_VO vo)
	{
		dao.update(vo);
		return new ModelAndView("redirect:View_retail_client.html");
		
	}
	
	@RequestMapping(value = { "/", "form.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("Admin/form");
	}


}

