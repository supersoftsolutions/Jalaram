package com.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.Add_wholesale_client_DAO;
import com.DAO.Sun_mon_product_DAO;
import com.VO.Add_wholesale_client_VO;
import com.VO.Product_mon_retail_VO;
import com.VO.Product_mon_wholesale_VO;
import com.VO.Product_sun_retail_VO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Wholesale_product_VO;

@Controller

public class Wholesale_product {

	@Autowired
	Add_wholesale_client_DAO dao;

	@Autowired
	Sun_mon_product_DAO sdao;

	@RequestMapping(value = "Add_wholesale_product.html", method = RequestMethod.GET)
	public ModelAndView index1() {
		List ls = dao.search1();
		return new ModelAndView("Admin/Add_wholesale_product", "data", new Wholesale_product_VO()).addObject("list",
				ls);
	}

	@RequestMapping(value = "insert_wholesale_product.html", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Wholesale_product_VO vo, HttpSession session) {
		Product_sun_wholesale_VO svo = new Product_sun_wholesale_VO();
		Product_mon_wholesale_VO mvo = new Product_mon_wholesale_VO();

		this.dao.product(vo);
		svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());
		sdao.update(mvo, vo);
		sdao.update(svo, vo);

		return new ModelAndView("redirect:Add_wholesale_product.html");
	}

	@RequestMapping(value = "View_wholesale_product.html", method = RequestMethod.GET)
	public ModelAndView search() {
		List ls = dao.search();
		return new ModelAndView("Admin/View_wholesale_product", "list", ls);
	}

	@RequestMapping(value = "delete_wholesale_product.html", method = RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, Wholesale_product_VO vo) {
		Product_sun_wholesale_VO svo = new Product_sun_wholesale_VO();
		Product_mon_wholesale_VO mvo = new Product_mon_wholesale_VO();
		
		vo.setProductid(id);

		String m=sdao.get(vo);
		
		sdao.delete(svo, vo, m);
		sdao.delete(mvo, vo, m);
		
		dao.delete(vo);

		return new ModelAndView("redirect:View_wholesale_product.html");
	}

	@RequestMapping(value = "edit_wholesale_product.html", method = RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id, Wholesale_product_VO vo) {

		List ls1 = dao.search1();
		vo.setProductid(id);
		List ls = dao.edit(vo);
		return new ModelAndView("Admin/Edit_wholesale_product", "data", (Wholesale_product_VO) ls.get(0))
				.addObject("list", ls1);
	}

	@RequestMapping(value = "update_wholesale_product.html", method = RequestMethod.POST)
	public ModelAndView update(@ModelAttribute Wholesale_product_VO vo) {

		Product_sun_wholesale_VO svo = new Product_sun_wholesale_VO();
		Product_mon_wholesale_VO mvo = new Product_mon_wholesale_VO();

		
		/*svo.setWvo(vo.getWvo());
		mvo.setWvo(vo.getWvo());*/
		sdao.update(mvo, vo);
		sdao.update(svo, vo);
		
		dao.update1(vo);
		return new ModelAndView("redirect:View_wholesale_product.html");

	}

}
