package com.controller;

import java.util.List;

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

import com.DAO.LabourDAO;
import com.DAO.LiveCounterDAO;
import com.DAO.ProductDAO;
import com.VO.ChargeVO;
import com.VO.LiveorderVO;
import com.VO.MiscellaneousVO;
import com.VO.ProductRateVO;
import com.VO.RegularorderVO;
import com.VO.Staff_leaveVO;
import com.VO.TransportVO;
import com.sun.research.ws.wadl.Request;



@Controller

public class LivecounterController {
	
	@Autowired
	ProductDAO pdao;
	
	@Autowired
	LiveCounterDAO dao;
	
	@Autowired
	LabourDAO ldao;
	
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
    public ModelAndView delete12(@RequestParam("id") int id, RegularorderVO vo,Model model)
    {
            vo.setRegular_orderid(id);
            
            //System.out.println(dao.insert1(vo));
            if(dao.insert1(vo).equals("Complete"))
            {
                System.out.println("hi");
                return new ModelAndView("redirect:view_regular_order.html","list1","hi");
                
            }
            else
            {
                dao.delete(vo);
                return new ModelAndView("redirect:view_regular_order.html");
            }
            //
            
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

		dao.update1(vo);
		return new ModelAndView("redirect:view_regular_order.html");

	}
	
	@RequestMapping(value = "Add_complete_order.html", method = RequestMethod.GET)
	public ModelAndView search(@ModelAttribute RegularorderVO vo) {
		
	LiveorderVO lvo = new LiveorderVO();
		
		List ls = dao.search2(vo);
		List ls1 = dao.search11(lvo);
		return new ModelAndView("Admin/Complete_order", "list", ls);
	}
	
	@RequestMapping(value="cancel_regular_order.html",method=RequestMethod.GET)
	public ModelAndView delete13(@RequestParam("id") int id, RegularorderVO vo)
	{
			vo.setRegular_orderid(id);
			dao.update(vo);
			return new ModelAndView("redirect:Add_complete_order.html");
	}
	
	
	
	
	
	@RequestMapping(value = { "/", "Add_live_order.html" }, method = RequestMethod.GET)
	public ModelAndView index123() {
		
		List ls1 = pdao.search2();

		List ls = pdao.search();
		
		List ls2 = dao.search(); 
		
		return new ModelAndView("Admin/Add_live_order", "data", new LiveorderVO()).addObject("clist", ls1).addObject("list",ls).addObject("plist", ls2);
			
		
	}
	
	
	@RequestMapping(value = "insert_live_order.html", method = RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute LiveorderVO vo,HttpSession session) {
		
		vo.setStatus("pending");
		vo.setLabour_charge("0");
		vo.setTransport_charge("0");
		vo.setTransport_name("0");
		vo.setTransport_type("0");
	

		this.dao.insert1(vo);

	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_live_order.html");
	}
	
	
	@RequestMapping(value = "view_live_order.html", method = RequestMethod.GET)
	public ModelAndView search11() {
		
		List ls = dao.search11();
		return new ModelAndView("Admin/View_live_order", "list", ls);
	}
	
	@RequestMapping(value="delete_live_order.html",method=RequestMethod.GET)
    public ModelAndView delete11(@RequestParam("id") int id, LiveorderVO vo,Model model)
    {
            vo.setLive_orderid(id);
            
            //System.out.println(dao.insert1(vo));
            if(dao.insert2(vo).equals("Complete"))
            {
                System.out.println("hi");
                return new ModelAndView("redirect:view_live_order.html","list1","hi");
                
            }
            else
            {
                dao.delete(vo);
                return new ModelAndView("redirect:view_live_order.html");
            }
            //
            
    }
	
	@RequestMapping(value = "edit_live_order.html", method = RequestMethod.GET)
	public ModelAndView edit11(@RequestParam("id") int id, LiveorderVO vo) {

		List ls = dao.search11();
		vo.setLive_orderid(id);
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_live_order", "data", (LiveorderVO) ls1.get(0));
				
	}
	
	@RequestMapping(value = "update_live_order.html", method = RequestMethod.POST)
	public ModelAndView update11(@ModelAttribute LiveorderVO vo) {

		dao.update1(vo);
		return new ModelAndView("redirect:view_live_order.html");

	}
	
	@RequestMapping(value = { "/", "Add_charge.html" }, method = RequestMethod.GET)
	public ModelAndView index13(@RequestParam("id") int id, RegularorderVO vo) {
		
		List ls2 = ldao.search1();
		List ls3 = ldao.search();
		List ls = dao.search1();
		vo.setRegular_orderid(id);
		List ls1 = dao.edit(vo);
  
		return new ModelAndView("Admin/Add_charges", "data",(RegularorderVO) ls1.get(0)).addObject("list", ls2).addObject("plist", ls3);
	}
	
	@RequestMapping(value = "insert_charge_order.html", method = RequestMethod.POST)
	public ModelAndView insert11(@ModelAttribute ChargeVO vo,HttpSession session) {
		
		this.dao.insert1(vo);

		return new ModelAndView("redirect:Add_charge.html");
	}
	
}
