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

import com.DAO.CreditorDAO;
import com.VO.Material_creditor_VO;
import com.VO.Product_creditor_VO;
import com.VO.Product_mon_wholesale_VO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Row_Material_VO;
import com.VO.Wholesale_product_VO;


@Controller

public class CreditorController {
	
	@Autowired
	CreditorDAO dao;
	
	
	@RequestMapping(value = { "/", "Add_product_creditor.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		return new ModelAndView("Admin/Add_product_creditor", "data", new Product_creditor_VO());
		
	}
	
	@RequestMapping(value = "insert_product_creditor.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Product_creditor_VO vo, HttpSession session) {
		
      vo.setBalance("0");
		this.dao.insert(vo);
		
	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_product_creditor.html");
	}
	
	@RequestMapping(value = "View_product_creditor.html", method = RequestMethod.GET)
	public ModelAndView search() {
		List ls = dao.search();
		return new ModelAndView("Admin/View_product_creditor", "list", ls);
	}
	
	@RequestMapping(value = "delete_creditor_product.html", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, Product_creditor_VO vo) {
		
		
		vo.setCreditorid(id);

		
		dao.delete(vo);

		return new ModelAndView("redirect:View_product_creditor.html");
	}
	
	@RequestMapping(value = "edit_creditor_product.html", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id, Product_creditor_VO vo) {

		List ls = dao.search();
		vo.setCreditorid(id);
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_creditor_product", "data", (Product_creditor_VO) ls1.get(0));
				
	}

	@RequestMapping(value = "update_creditor_product.html", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute Product_creditor_VO vo) {

		
		
		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		
		dao.update1(vo);
		return new ModelAndView("redirect:View_product_creditor.html");

	}
	
	@RequestMapping(value = { "/", "Add_material_creditor.html" }, method = RequestMethod.GET)
	public ModelAndView index1() {
		
		return new ModelAndView("Admin/Add_material_creditor", "data", new Material_creditor_VO());
		
	}
	
	@RequestMapping(value = "insert_material_creditor.html", method = RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute Material_creditor_VO vo, HttpSession session) {
		
      vo.setBalance("0");
		this.dao.insert(vo);
		
	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_material_creditor.html");
	}
	
	@RequestMapping(value = "View_material_creditor.html", method = RequestMethod.GET)
	public ModelAndView search1() {
		List ls = dao.search1();
		return new ModelAndView("Admin/View_material_creditor", "list", ls);
		
		
	}
	
	@RequestMapping(value = "delete_creditor_material.html", method = RequestMethod.GET)
	public ModelAndView delete1(@RequestParam("id") int id, Material_creditor_VO vo) {
		
		
		vo.setCreditorid(id);

		
		dao.delete(vo);

		return new ModelAndView("redirect:View_product_creditor.html");
	}
	
	@RequestMapping(value = "edit_creditor_material.html", method = RequestMethod.GET)
	public ModelAndView edit1(@RequestParam("id") int id, Material_creditor_VO vo) {

		List ls = dao.search1();
		vo.setCreditorid(id);
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_creditor_material", "data", (Material_creditor_VO) ls1.get(0));
				
	}
	
	@RequestMapping(value = "update_creditor_material.html", method = RequestMethod.POST)
	public ModelAndView update1(@ModelAttribute Material_creditor_VO vo) {

		
		
		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		
		dao.update1(vo);
		return new ModelAndView("redirect:View_material_creditor.html");

	}


}
