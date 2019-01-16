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

import com.DAO.LiveCounterDAO;
import com.DAO.ProductDAO;
import com.VO.MiscellaneousVO;
import com.VO.ProductRateVO;
import com.VO.RegularorderVO;
import com.VO.Staff_leaveVO;



@Controller

public class LivecounterController {
	
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	LiveCounterDAO dao;
	
	@RequestMapping(value = { "/", "Add_product_rate.html" }, method = RequestMethod.GET)
	public ModelAndView index1() {
		
		
		List ls2 = pdao.search2();
		List ls = pdao.search();
		//ls.add("Patra");
		
	//	ls.add("Patra");


	       
		return new ModelAndView("Admin/Add_product_rate", "data", new ProductRateVO()).addObject("list",ls).addObject("plist", ls2);
			
		
	}
	
	@RequestMapping(value = "insert_product_rate.html", method = RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute ProductRateVO vo,HttpSession session) {
		


		this.dao.insert(vo);

	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_product_rate.html");
	}
	
	@RequestMapping(value = "view_product_rate.html", method = RequestMethod.GET)
	public ModelAndView search1() {
		
		List ls = dao.search();
		return new ModelAndView("Admin/View_product_rate", "list", ls);
	}
	
	@RequestMapping(value="delete_product_rate",method=RequestMethod.GET)
	public ModelAndView delete1(@RequestParam("id") int id, ProductRateVO vo)
	{
			vo.setID(id);
			dao.delete(vo);
			return new ModelAndView("redirect:view_product_rate.html");
	}
	
	@RequestMapping(value = "edit_product_rate.html", method = RequestMethod.GET)
	public ModelAndView edit1(@RequestParam("id") int id, ProductRateVO vo) {

		List ls = dao.search();
		vo.setID(id);
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_product_rate", "data", (ProductRateVO) ls1.get(0));
				
	}
	
	@RequestMapping(value = "update_product_rate.html", method = RequestMethod.POST)
	public ModelAndView update1(@ModelAttribute ProductRateVO vo) {

		
		
		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		
		dao.update1(vo);
		return new ModelAndView("redirect:view_product_rate.html");

	}
	
	@RequestMapping(value = { "/", "Add_regular_order.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		
		List ls = pdao.search();
		
		return new ModelAndView("Admin/Add_regular_order", "data", new RegularorderVO()).addObject("list",ls);
			
		
	}
	
	@RequestMapping(value = "insert_regular_order.html", method = RequestMethod.POST)
	public ModelAndView insert12(@ModelAttribute RegularorderVO vo,HttpSession session) {
		
		vo.setStatus("pending");
		vo.setLabour_charge("0");
		vo.setTransport_charge("0");
		vo.setTransport_name("0");
		vo.setTransport_type("0");
	

		this.dao.insert(vo);

	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_regular_order.html");
	}
	
	@RequestMapping(value = "view_regular_order.html", method = RequestMethod.GET)
	public ModelAndView search12() {
		
		List ls = dao.search1();
		return new ModelAndView("Admin/View_regular_order", "list", ls);
	}
	
	@RequestMapping(value="delete_regular_order.html",method=RequestMethod.GET)
	public ModelAndView delete12(@RequestParam("id") int id, RegularorderVO vo)
	{
			vo.setRegular_orderid(id);
			dao.delete(vo);
			return new ModelAndView("redirect:view_regular_order.html");
	}
	
	@RequestMapping(value = "edit_regular_order.html", method = RequestMethod.GET)
	public ModelAndView edit12(@RequestParam("id") int id, RegularorderVO vo) {

		List ls = dao.search1();
		vo.setRegular_orderid(id);
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_regular_order", "data", (RegularorderVO) ls1.get(0));
				
	}
	
	@RequestMapping(value = "update_regular_order.html", method = RequestMethod.POST)
	public ModelAndView update12(@ModelAttribute RegularorderVO vo) {

		
		
		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		
		dao.update1(vo);
		return new ModelAndView("redirect:view_regular_order.html");

	}
}
