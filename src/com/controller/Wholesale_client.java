package com.controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.DAO.Add_wholesale_client_DAO;
import com.DAO.LoginDAO;
import com.VO.Add_wholesale_client_VO;
import com.VO.LoginVO;

@Controller
public class Wholesale_client {
	
	
	@Autowired
	Add_wholesale_client_DAO dao;
	
	@Autowired
	LoginDAO ldao;
	
	String password;
	
	@RequestMapping(value="Add_wholesale_client.html",method=RequestMethod.GET)
	public ModelAndView index1()
	{
		return new ModelAndView("Admin/Add_wholesale_client","data",new Add_wholesale_client_VO());
	}
	
	@RequestMapping(value="add_wholesale_client.html",method=RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute Add_wholesale_client_VO  vo,HttpSession session)
	{
		
		session.setAttribute("generatePswd",password);
		 
		 LoginVO lvo=new LoginVO();
			lvo.setUserName(vo.getMobile());
			lvo.setPassword(password);

			lvo.setEnabled("1");
			lvo.setRole("ROLE_USER");
			this.ldao.insert(lvo);
			vo.setLvo(lvo);
		
		
		this.dao.insert(vo);
		
				
		
		
		return new ModelAndView("redirect:Add_wholesale_client.html");
	}
	
	private char[] generatePswd(int length) {
		
		 {
		        int length1 = 6; // password length
		        System.out.println(generatePswd(length1));
		    }
		   
		
		{
	        System.out.println("Your Password:");
	        String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String chars = "abcdefghijklmnopqrstuvwxyz";
	        String nums = "0123456789";
	        

	        String passSymbols = charsCaps + chars + nums;
	        Random rnd = new Random();
	         
	        int len = 0;
			char[] password = new char[len];
	        int index = 0;
	        for (int i = 0; i < len; i++) 
	        {
	            password[i] = passSymbols.charAt(rnd.nextInt(passSymbols.length()));
	            
	        }
	       
	    }


		return null;
	}
}
