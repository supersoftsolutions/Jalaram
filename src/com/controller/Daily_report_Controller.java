package com.controller;

import java.awt.PageAttributes.MediaType;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Request;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.Daily_report_DAO;
import com.VO.Add_wholesale_client_VO;
import com.VO.Daily_report1_VO;
import com.VO.Daily_report_VO;
import com.VO.Product_mon_retail_VO;
import com.VO.Product_mon_wholesale_VO;
import com.VO.Product_sun_retail_VO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Retail_client_VO;
import com.mysql.fabric.Response;


@Controller

public class Daily_report_Controller {

	@Autowired
	Daily_report_DAO dao;

	public static boolean empty(final String s) {
		return s == null || s.trim().isEmpty();
	}

	@Scope("session")
	@RequestMapping(value = "Daily_report.html", method = RequestMethod.GET)
	public ModelAndView index12(@ModelAttribute Product_mon_retail_VO vo,Model model,HttpSession session)
	{
		//System.out.println(model);
		//System.out.println(sessionStorage.getItem("lastname"));
		//var myVal = '<%= session.getAttribute("ShowMessage") %>';

		//System.out.println((String) session.getAttribute("lastname"));

		Product_mon_retail_VO mrvo =new Product_mon_retail_VO();
		Product_sun_retail_VO srvo =new Product_sun_retail_VO();
		Product_mon_wholesale_VO mwvo =new Product_mon_wholesale_VO();
		Product_sun_wholesale_VO swvo =new Product_sun_wholesale_VO();
		Retail_client_VO cvo=new Retail_client_VO();
		Daily_report_VO dvo=new Daily_report_VO();
		Add_wholesale_client_VO wvo=new Add_wholesale_client_VO();

		Calendar cal = Calendar.getInstance();
	       Date d = null;
	       DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	       DateFormat dateFormat1 = new SimpleDateFormat("EEE");
	       cal.add(Calendar.DATE, 1);

		   String s=null,m=null,m1=null;

	      // String m1=(String) session.getValue("lastname");
	       //String m1=(String) session.getAttribute("lastname");
	        m1= (String) session.getAttribute("lastname");

	        //System.out.println(session.getAttribute("sa"));
	       System.out.println(m1);

	       //if(empty((String) session.getAttribute("lastname"))||(String) session.getAttribute("lastname")==null)
	       if(empty(m1)||m1==null)
	       {
	    	   s = dateFormat.format(cal.getTime());

		       m = dateFormat1.format(cal.getTime());
		   }
	       else
	       {
				//String cart = (String) session.getAttribute("lastname");
				s = dateFormat.format(m1);

			    m = dateFormat1.format(m1);
	       }

	    dao.delete();

		//System.out.println(s);
		if(m.equals("Sun"))
		{
			dao.insert(dvo, srvo, wvo,swvo,s);
		}
		else
		{
			dao.insert(dvo, mrvo, cvo,mwvo,s);
		}

		//return new ModelAndView("Admin/Daily_Report");

		/*ArrayList<Daily_report1_VO> list = new ArrayList<>();
		list.get();*/

		List<String> ls = dao.search();
		//return new ModelAndView("Admin/Daily_Report", "list" ,ls,s);

		model.addAttribute("list1", s);
		model.addAttribute("list2", m);
		model.addAttribute("list", ls);
		

		//return new ModelAndView("Admin/Daily_Report", "list" ,ls);
		return new ModelAndView("Admin/Daily_Report");
	}
	
	@RequestMapping(value = "demo1.html", method = RequestMethod.GET,produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String demo1(@RequestParam("date") String date,Model model1,@ModelAttribute Daily_report_VO vo)
	//public String demo1(@RequestParam("date") String date)
	{
		//product_mon_retail_VO
		
		//date="2018-12-12";
		//System.out.println(date);
		//return "hi "+date;

		Product_mon_retail_VO mrvo =new Product_mon_retail_VO();
		Product_sun_retail_VO srvo =new Product_sun_retail_VO();
		Product_mon_wholesale_VO mwvo =new Product_mon_wholesale_VO();
		Product_sun_wholesale_VO swvo =new Product_sun_wholesale_VO();
		Retail_client_VO cvo=new Retail_client_VO();
		Daily_report_VO dvo=new Daily_report_VO();
		Add_wholesale_client_VO wvo=new Add_wholesale_client_VO();
		
		String s=null,m=null;

		 DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	       DateFormat dateFormat1 = new SimpleDateFormat("EEE");


	      // System.out.println(date);
	       //s = dateFormat.format(date);
	       Date date1 = null;
	       try {
			date1=new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		    m = dateFormat1.format(date1);

		    System.out.println(m);
		    System.out.println(date1);

		dao.delete();

		//System.out.println(s);
		if(m.equals("Sun"))
		{	
			dao.insert(dvo, srvo, wvo,swvo,date);
		}
		else
		{
			dao.insert(dvo, mrvo, cvo,mwvo,date);
		}
		List<String> ls = dao.search();
		//return new ModelAndView("Admin/Daily_Report", "list" ,ls,s);

		/*model1.addAttribute("list1", date);
		model1.addAttribute("list2", m);*/
		//model1.addAttribute("list99", ls);
		model1.addAttribute("list99", ls);
		System.out.println((model1).addAttribute("list99", ls));
		//return new ModelAndView("Admin/Daily_Report", "list" ,ls);
		System.out.println(ls);
		//return date;
		
		return date;
		//return new ModelAndView("Admin/Daily_Report");
	}
}	