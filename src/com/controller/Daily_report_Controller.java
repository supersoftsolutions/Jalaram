package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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



@Controller




public class Daily_report_Controller {
	
	@Autowired
	Daily_report_DAO dao;
	
	@RequestMapping(value = "Daily_report.html", method = RequestMethod.GET)
	public ModelAndView index12(@ModelAttribute Product_mon_retail_VO vo)
	{
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
	       String s = dateFormat.format(cal.getTime());
	       String m = dateFormat1.format(cal.getTime());
		
		dao.delete();
		//System.out.println(dvo.getDay());
		//String m=dvo.getDay();
		
		if(m.equals("sun"))
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
		
		List ls = dao.search();
		return new ModelAndView("Admin/Daily_Report", "list" ,ls);
		
	}


}
