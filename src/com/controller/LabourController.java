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

import com.DAO.LabourDAO;
import com.VO.AccountVO;
import com.VO.LabourVO;
import com.VO.TransportVO;



@Controller

public class LabourController {
	
	@Autowired
	LabourDAO dao;
	
	@RequestMapping(value = { "/", "Add_labour.html" }, method = RequestMethod.GET)
	public ModelAndView index() {
		
		return new ModelAndView("Admin/Add_Labour", "data", new LabourVO());
		
	}
	
	@RequestMapping(value = "insert_labour.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute LabourVO vo, HttpSession session) {
		
      vo.setBalance("0");
		this.dao.insert(vo);
		
	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_labour.html");
	}
	
	@RequestMapping(value = "view_labour.html", method = RequestMethod.GET)
	public ModelAndView search() {
		List ls = dao.search();
		return new ModelAndView("Admin/View_labour", "list", ls);
	}
	
	@RequestMapping(value = "delete_labour.html", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, LabourVO vo) {
		
		
		vo.setLabourid(id);

		
		dao.delete(vo);

		return new ModelAndView("redirect:view_labour.html");
	}
	
	@RequestMapping(value = "edit_labour.html", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id, LabourVO vo) {

		List ls = dao.search();
		vo.setLabourid(id);		
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_labour", "data", (LabourVO) ls1.get(0));
				
	}

	@RequestMapping(value = "update_labour.html", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute LabourVO vo) {

		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		dao.update1(vo);
		return new ModelAndView("redirect:view_labour.html");

	}
	
	@RequestMapping(value = { "/", "Add_transport.html" }, method = RequestMethod.GET)
	public ModelAndView index1() {
		
		return new ModelAndView("Admin/Add_transport", "data", new TransportVO());
		
	}
	
	@RequestMapping(value = "insert_transport.html", method = RequestMethod.POST)
	public ModelAndView insert1(@ModelAttribute TransportVO vo, HttpSession session) {
		
      vo.setBalance("0");
		this.dao.insert(vo);
		
	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_transport.html");
	}
	
	@RequestMapping(value = "view_transport.html", method = RequestMethod.GET)
	public ModelAndView search1() {
		List ls = dao.search1();
		return new ModelAndView("Admin/View_transport", "list", ls);
	}
	
	@RequestMapping(value = "delete_transport.html", method = RequestMethod.GET)
	public ModelAndView delete1(@RequestParam("id") int id, TransportVO vo) {
		
		
		vo.setTransportid(id);

		
		dao.delete(vo);

		return new ModelAndView("redirect:view_transport.html");
	}
	
	@RequestMapping(value = "edit_transport.html", method = RequestMethod.GET)
	public ModelAndView edit1(@RequestParam("id") int id, TransportVO vo) {

		List ls = dao.search();
		vo.setTransportid(id);		
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_transport", "data", (TransportVO) ls1.get(0));
				
	}

	@RequestMapping(value = "update_transport.html", method = RequestMethod.POST)
	public ModelAndView update1(@ModelAttribute TransportVO vo) {

		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		dao.update1(vo);
		return new ModelAndView("redirect:view_transport.html");

	}
	
	@RequestMapping(value = { "/", "Add_account.html" }, method = RequestMethod.GET)
	public ModelAndView index12() {
		
		return new ModelAndView("Admin/Add_account", "data", new AccountVO());
		
	}
	
	@RequestMapping(value = "insert_account.html", method = RequestMethod.POST)
	public ModelAndView insert11(@ModelAttribute AccountVO vo, HttpSession session) {
		
		this.dao.insert(vo);
		
	//	svo.setIdada("0");


		return new ModelAndView("redirect:Add_account.html");
	
	}
	
	@RequestMapping(value = "view_account.html", method = RequestMethod.GET)
	public ModelAndView search12() {
		List ls = dao.search12();
		return new ModelAndView("Admin/View_account", "list", ls);
	}
	
	@RequestMapping(value = "delete_account.html", method = RequestMethod.GET)
	public ModelAndView delete12(@RequestParam("id") int id, AccountVO vo) {
		
		
		vo.setAccountid(id);

		
		dao.delete(vo);

		return new ModelAndView("redirect:view_account.html");
	}
	
	@RequestMapping(value = "edit_account.html", method = RequestMethod.GET)
	public ModelAndView edit12(@RequestParam("id") int id, AccountVO vo) {

		List ls = dao.search12();
		vo.setAccountid(id);		
		List ls1 = dao.edit(vo);
		return new ModelAndView("Admin/Edit_account", "data", (AccountVO) ls1.get(0));
				
	}

	@RequestMapping(value = "update_account.html", method = RequestMethod.POST)
	public ModelAndView update12(@ModelAttribute AccountVO vo) {

		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		
		dao.update1(vo);
		return new ModelAndView("redirect:view_account.html");

	}
	
	

}
