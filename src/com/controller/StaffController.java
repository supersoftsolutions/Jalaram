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

import com.DAO.ProductDAO;
import com.DAO.StaffDAO;
import com.VO.Extra_hoursVO;
import com.VO.Material_creditor_VO;
import com.VO.MiscellaneousVO;
import com.VO.Row_Material_VO;
import com.VO.Row_Material_purchase_VO;
import com.VO.StaffVO;
import com.VO.Staff_leaveVO;

@Controller


public class StaffController {
	
	@Autowired
	StaffDAO dao;
	
	@Autowired
	ProductDAO pdao;
	
	
	@RequestMapping(value = { "/", "Add_staff_leave.html" }, method = RequestMethod.GET)
	public ModelAndView index1() {
		
		List ls = pdao.search1();

	       
		return new ModelAndView("Admin/Add_staff_leave", "data", new Staff_leaveVO()).addObject("list",ls);
			
		
	}
	
	@RequestMapping(value = "insert_staff_leave.html", method = RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute Staff_leaveVO vo,HttpSession session) {
		


		this.dao.insert(vo);

	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_staff_leave.html");
	}
	@RequestMapping(value = "view_staff_leave.html", method = RequestMethod.GET)
	public ModelAndView search1() {
		
		List ls = dao.search1();
		return new ModelAndView("Admin/View_staff_leave", "list", ls);
	}
	
	@RequestMapping(value="delete_staff_leave.html",method=RequestMethod.GET)
	public ModelAndView delete1(@RequestParam("id") int id, Staff_leaveVO vo)
	{
			vo.setStaff_leaveid(id);
			dao.delete(vo);
			return new ModelAndView("redirect:view_staff_leave.html");
	}
	
	@RequestMapping(value = { "/", "Add_extra_hours.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		List ls = pdao.search1();

	       
		return new ModelAndView("Admin/Add_extra_hours", "data", new Extra_hoursVO()).addObject("list",ls);
			
		
	}
	
	@RequestMapping(value = "insert_extra_hours.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Extra_hoursVO vo,HttpSession session) {
		
		StaffVO svo = new StaffVO();


		this.dao.insert(vo);
		dao.update(svo, vo);


	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_extra_hours.html");
	}
	
	@RequestMapping(value = "view_extra_hours.html", method = RequestMethod.GET)
	public ModelAndView search() {
		
		List ls = dao.search12();
		return new ModelAndView("Admin/View_extra_hours", "list", ls);
	}
	
	@RequestMapping(value="delete_extra_hours.html",method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, Extra_hoursVO vo)
	{
		StaffVO svo = new StaffVO();

			vo.setExtra_hoursid(id);
			
				String m=dao.get(vo);
			
			dao.update1(svo, vo, m,id);
			dao.delete(vo);
			return new ModelAndView("redirect:view_extra_hours.html");
	}
	
	@RequestMapping(value = { "/", "Add_miscellaneous.html" }, method = RequestMethod.GET)
	public ModelAndView index12() {
		

	       
		return new ModelAndView("Admin/Add_miscellaneous", "data", new MiscellaneousVO());
			
		
	}
	
	@RequestMapping(value = "insert_miscellaneous.html", method = RequestMethod.POST)
	public ModelAndView insert12(@ModelAttribute MiscellaneousVO vo,HttpSession session) {
		

		vo.setBalance("0");
		this.dao.insert(vo);

	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_miscellaneous.html");
	}
	
	@RequestMapping(value = "view_miscellaneous.html", method = RequestMethod.GET)
	public ModelAndView search12() {
		
		List ls = dao.search2();
		return new ModelAndView("Admin/View_miscellaneous", "list", ls);
	}
	
	@RequestMapping(value="delete_miscellaneous.html",method=RequestMethod.GET)
	public ModelAndView delete12(@RequestParam("id") int id, MiscellaneousVO vo)
	{
		vo.setId(id);
			dao.delete(vo);
			return new ModelAndView("redirect:view_miscellaneous.html");
	}
	
	@RequestMapping(value = "edit_miscellaneous.html", method = RequestMethod.GET)
	public ModelAndView edit1(@RequestParam("id") int id, MiscellaneousVO vo) {

		List ls = dao.search2();
		vo.setId(id);
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_miscellaneous", "data", (MiscellaneousVO) ls1.get(0));
				
	}
	
	@RequestMapping(value = "update_miscellaneous.html", method = RequestMethod.POST)
	public ModelAndView update1(@ModelAttribute MiscellaneousVO vo) {

		
		
		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		
		dao.update1(vo);
		return new ModelAndView("redirect:view_miscellaneous.html");

	}

	
}
