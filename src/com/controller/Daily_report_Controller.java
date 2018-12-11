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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.VO.Daily_report_VO;
import com.VO.Retail_client_VO;

@Controller


public class Daily_report_Controller {
	
	@RequestMapping(value = { "/", "Daily_report.html" }, method = RequestMethod.GET)
	public ModelAndView index(@ModelAttribute Daily_report_VO  vo) {
		Calendar cal = Calendar.getInstance();
		Date d = null;
        //DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        cal.add(Calendar.DATE, 1);
        String s = dateFormat.format(cal.getTime());
       
        try
        {
            d = (Date) dateFormat.parse(s);
            String date = null;
			vo.setDate(s);
          //  vo.setMaxSelectableDate(d);*
           // dateChooser.setMinSelectableDate(d);
            System.out.println(s);
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
		return new ModelAndView("Admin/Daily_Report");
	}

}
