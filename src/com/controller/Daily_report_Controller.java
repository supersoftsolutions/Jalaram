package com.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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


@Controller




public class Daily_report_Controller {
	
	@Autowired
	Daily_report_DAO dao;
	
	@RequestMapping(value = "Daily_report.html", method = RequestMethod.GET)
	public ModelAndView index12(@ModelAttribute Daily_report1_VO vo)

	{

		List ls = dao.search();
		return new ModelAndView("Admin/Daily_report", "list", ls);
	}


}
