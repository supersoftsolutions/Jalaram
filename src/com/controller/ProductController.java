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
import com.VO.CaterersVO;
import com.VO.ExpenseVO;
import com.VO.ProductVO;
import com.VO.Product_creditor_VO;
import com.VO.Row_Material_VO;
import com.VO.StaffVO;


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
	
	@RequestMapping(value = "View_product.html", method = RequestMethod.GET)
	public ModelAndView search() {
		
		List ls = dao.search();
		return new ModelAndView("Admin/View_product", "list", ls);
	}
	
	@RequestMapping(value="delete_product.html",method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, ProductVO vo)
	{
			vo.setID(id);
			dao.delete(vo);
			return new ModelAndView("redirect:View_product.html");
	}
	

	@RequestMapping(value = { "/", "Add_staff.html" }, method = RequestMethod.GET)
	public ModelAndView index1() {
		
		return new ModelAndView("Admin/Add_staff", "data", new StaffVO());
		
	}
	@RequestMapping(value = "insert_staff.html", method = RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute StaffVO vo, HttpSession session) {
		
		vo.setBalance("0");
		this.dao.insert(vo);
	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_staff.html");
	}
	
	@RequestMapping(value = "view_staff.html", method = RequestMethod.GET)
	public ModelAndView search1() {
		
		List ls = dao.search1();
		return new ModelAndView("Admin/View_staff", "list", ls);
	}
	
	@RequestMapping(value="delete_staff.html",method=RequestMethod.GET)
	public ModelAndView delete1(@RequestParam("id") int id, StaffVO vo)
	{
			vo.setStaffid(id);
			dao.delete(vo);
			return new ModelAndView("redirect:view_staff.html");
	}
	
	@RequestMapping(value = "edit_staff.html", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id, StaffVO vo) {

		List ls = dao.search1();
		vo.setStaffid(id);
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_staff", "data", (StaffVO) ls1.get(0));
				
	}

	@RequestMapping(value = "update_staff.html", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute StaffVO vo) {

		
		
		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		
		dao.update1(vo);
		return new ModelAndView("redirect:view_staff.html");

	}
	
	@RequestMapping(value = { "/", "Add_caterers.html" }, method = RequestMethod.GET)
	public ModelAndView index2() {
		
		return new ModelAndView("Admin/Add_caterers", "data", new CaterersVO());
		
	}
	
	@RequestMapping(value = "insert_caterers.html", method = RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute CaterersVO vo, HttpSession session) {
		
		vo.setBalance("0");

		this.dao.insert(vo);
	
		return new ModelAndView("redirect:Add_caterers.html");
	}
	
	@RequestMapping(value = "view_caterers.html", method = RequestMethod.GET)
	public ModelAndView search2() {
		
		List ls = dao.search2();
		return new ModelAndView("Admin/View_caterers", "list", ls);
	}
	
	@RequestMapping(value="delete_caterers.html",method=RequestMethod.GET)
	public ModelAndView delete12(@RequestParam("id") int id, CaterersVO vo)
	{
			vo.setCaterersid(id);
			dao.delete(vo);
			return new ModelAndView("redirect:view_staff.html");
	}
	
	@RequestMapping(value = "edit_caterers.html", method = RequestMethod.GET)
	public ModelAndView edit1(@RequestParam("id") int id, CaterersVO vo) {

		List ls = dao.search2();
		vo.setCaterersid(id);
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_caterers", "data", (CaterersVO) ls1.get(0));
				
	}

	@RequestMapping(value = "update_caterers.html", method = RequestMethod.POST)
	public ModelAndView update1(@ModelAttribute CaterersVO vo) {

		
		
		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		
		dao.update1(vo);
		return new ModelAndView("redirect:view_caterers.html");

	}
	
	@RequestMapping(value = { "/", "Add_expense.html" }, method = RequestMethod.GET)
	public ModelAndView index21() {
		
		return new ModelAndView("Admin/Add_Expense", "data", new ExpenseVO());
		
	}
	@RequestMapping(value = "insert_expense.html", method = RequestMethod.POST)
	public ModelAndView insert12(@ModelAttribute ExpenseVO vo, HttpSession session) {
		
		vo.setBalance("0");
		this.dao.insert(vo);
	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_expense.html");
	}
	
	@RequestMapping(value = "view_expense.html", method = RequestMethod.GET)
	public ModelAndView search12() {
		
		List ls = dao.search12();
		return new ModelAndView("Admin/View_expense", "list", ls);
	}
	
	@RequestMapping(value="delete_expense.html",method=RequestMethod.GET)
	public ModelAndView delete12(@RequestParam("id") int id, ExpenseVO vo)
	{
			vo.setID(id);
			dao.delete(vo);
			return new ModelAndView("redirect:view_expense.html");
	}
	
}
