package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.VO.Add_wholesale_client_VO;

@Controller
public class Retail_client {

	@RequestMapping(value="Add_retail_client.html",method=RequestMethod.GET)
	public ModelAndView index12()
	{
		return new ModelAndView("Admin/Add_retail_client","data",new Add_wholesale_client_VO());
	}
}
