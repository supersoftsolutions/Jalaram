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

import com.DAO.LoginDAO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Row_Material_VO;
import com.VO.Row_Material_purchase_VO;
@Controller
public class Row_MaterialController {
	
	@Autowired
	LoginDAO dao;
	
	
	
	
	
	@RequestMapping(value = { "/", "row_material.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		return new ModelAndView("Admin/Row_Material", "data", new Row_Material_VO());
		
	}
	
	@RequestMapping(value = "insert_row_material.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Row_Material_VO vo, HttpSession session) {
		
      vo.setStock("0");
		this.dao.insert(vo);
		
	//	svo.setIdada("0");


		return new ModelAndView("redirect:row_material.html");
	}
	
	@RequestMapping(value = "View_row_material.html", method = RequestMethod.GET)
	public ModelAndView search() {
		List ls = dao.search();
		return new ModelAndView("Admin/View_row_material", "list", ls);
	}
	
	@RequestMapping(value="delete_row_material.html",method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, Row_Material_VO vo)
	{
			vo.setID(id);
			dao.delete(vo);
			return new ModelAndView("redirect:View_row_material.html");
	}
	
	@RequestMapping(value = { "/", "purchase_row_material.html" }, method = RequestMethod.GET)
	public ModelAndView index1() {
		
		List ls = dao.search();

	       
		return new ModelAndView("Admin/Row_Material_purchase", "data", new Row_Material_purchase_VO()).addObject("list",ls);
			
		
	}
	
	@RequestMapping(value = "insert_row_material_purchase.html", method = RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute Row_Material_purchase_VO vo,HttpSession session) {
		
		Row_Material_VO rvo = new Row_Material_VO();


		this.dao.insert(vo);

		dao.update(rvo, vo);
	//	svo.setIdada("0");


		return new ModelAndView("redirect:purchase_row_material.html");
	}
	
	@RequestMapping(value = "View_row_material_purchase.html", method = RequestMethod.GET)
	public ModelAndView search1() {
		List ls = dao.search1();
		return new ModelAndView("Admin/View_Row_material_purchase", "list", ls);
	}
	
	@RequestMapping(value="delete_row_material_purchase.html",method=RequestMethod.GET)
	public ModelAndView delete1(@RequestParam("id") int id, Row_Material_purchase_VO vo)
	{
		
		Row_Material_VO rvo = new Row_Material_VO();

			vo.setPurchaseid(id);
			
			String m=dao.get(vo);

			dao.update1(rvo, vo, m);

			dao.delete(vo);
			return new ModelAndView("redirect:View_row_material_purchase.html");
	}
	
}
