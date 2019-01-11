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
		//ls.add("Patra");
		
	//	ls.add("Patra");


	       
		return new ModelAndView("Admin/Add_regular_order", "data", new RegularorderVO()).addObject("list",ls);
			
		
	}

}
