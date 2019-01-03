package com.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.ProductDAO;
import com.VO.ProductVO;
import com.VO.Row_Material_VO;


@Controller

public class ProductController {
	
	@Autowired
	ProductDAO dao;
	
	@RequestMapping(value = { "/", "Add_product.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		return new ModelAndView("Admin/Add_product", "data", new ProductVO());
		
	}
	
	@RequestMapping(value = "insert_product.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute ProductVO vo, HttpSession session) {
		

		this.dao.insert(vo);
	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_product.html");
	}

}
