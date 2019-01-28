package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.hibernate.internal.util.collections.ConcurrentReferenceHashMap.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.DAO.CreditorDAO;
import com.DAO.LoginDAO;
import com.DAO.PurchaseDAO;
import com.VO.Material_purchaseVO;
import com.VO.Order_purchaseVO;
import com.VO.ProductRateVO;
import com.VO.Product_creditor_VO;
import com.VO.PurchaseVO;
import com.sun.research.ws.wadl.Request;



@Controller

public class PurchaseController {
	
	@Autowired
	CreditorDAO dao;
	
	@Autowired
	PurchaseDAO pdao;
	
	@Autowired
	LoginDAO ldao;
	
	
	@RequestMapping(value = { "/", "Add_product_purchase.html" }, method = RequestMethod.GET)
	public ModelAndView index1() {
	
		List ls = dao.search();

	
		return new ModelAndView("Admin/Add_purchase", "data", new PurchaseVO()).addObject("list",ls);
		
	}
	
	@RequestMapping(value="jsonpurchase.html",method=RequestMethod.GET)
	public ModelAndView SubCategory(@ModelAttribute Product_creditor_VO vo,PurchaseVO pvo,@RequestParam("productId") String i)
	{
	    System.out.println("in con of sub");
	 	    pvo.setProduct(i);
		//vo.setCreditorid(i);
		
		pvo.setPvo(vo);

		List ls1=this.pdao.add(pvo);
		
	    System.out.print("list of subcat:"+ls1.size());
		
		return new ModelAndView("admin/Jsonpurchase","purcahselist",ls1);
	}
	
	
	@RequestMapping(value = "insert_product_purchase.html", method = RequestMethod.POST)
	public ModelAndView insert1(@RequestParam("id") int id,@ModelAttribute PurchaseVO vo,HttpSession session) {
	
		Product_creditor_VO pvo = new Product_creditor_VO();
		pvo.setCreditorid(id);
		
		this.pdao.insert(vo);
		pdao.update(pvo, vo);

	//	svo.setIdada("0");

		return new ModelAndView("redirect:Add_product_purchase.html");
	}
	
	
	@RequestMapping(value = "View_product_purchase.html", method = RequestMethod.GET)
	public ModelAndView search() {
		List ls = pdao.search();
		return new ModelAndView("Admin/View_product_purchase", "list", ls);
	}
	
	@RequestMapping(value = { "/", "Add_material_purchase.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		List ls = dao.search();
		List ls2 = ldao.search();
	       
		return new ModelAndView("Admin/Add_material_purchase", "data", new Material_purchaseVO()).addObject("list",ls).addObject("rlist", ls2);
			
		
	}
	
	@RequestMapping(value = "insert_material_purchase.html", method = RequestMethod.POST)
	public ModelAndView insert12(@ModelAttribute Material_purchaseVO vo,HttpSession session) {
		Product_creditor_VO pvo = new Product_creditor_VO();

		this.pdao.insert(vo);
		//pdao.update(pvo, vo);

	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_material_purchase.html");
	}
	
	@RequestMapping(value = { "/", "Add_order_purchase.html" }, method = RequestMethod.GET)
	public ModelAndView index12() {
		
		Product_creditor_VO pvo = new Product_creditor_VO();
		List ls = dao.search();
	//	List ls1 = pdao.search1(pvo);
	
		return new ModelAndView("Admin/Add_order_purchase", "data", new Order_purchaseVO()).addObject("list",ls);
			
		
	}
	
	@RequestMapping(value = "insert_order_purchase.html", method = RequestMethod.POST)
	public ModelAndView insert11(@ModelAttribute Order_purchaseVO vo,HttpSession session) {
	
		this.pdao.insert(vo);
	//	pdao.update(pvo, vo);

	//	svo.setIdada("0");
		
		return new ModelAndView("redirect:Add_order_purchase.html");
	}
	
	@RequestMapping(value = "View_order_purchase.html", method = RequestMethod.GET)
	public ModelAndView search1() {
		
		List ls = pdao.search1();
		return new ModelAndView("Admin/View_order_purchase", "list", ls);
	}

}
