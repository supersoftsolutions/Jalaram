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
import com.DAO.LoginDAO;
import com.VO.Add_wholesale_client_VO;
import com.VO.LoginVO;

@Controller
public class Wholesale_client {
	
	
	@Autowired
	Add_wholesale_client_DAO dao;
	
	@Autowired
	LoginDAO ldao;
	
	String password="";
	
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
		 
		 String mansi=generatePswd(6);
			lvo.setUserName(vo.getMobile());
			//System.out.println(mansi);
			lvo.setPassword(mansi);

			lvo.setEnabled("1");
			lvo.setRole("ROLE_USER");
			this.ldao.insert(lvo);
		
			//System.out.println(dao.i);
			//if(empty(dao.i.toString()))
			/*if(dao.i.equals(null))
			{
				System.out.println("empty method");
			}
			else
			{*/
			vo.setLvo(lvo);

				vo.setPassword(mansi);
				this.dao.insert(vo);
			//}
		return new ModelAndView("redirect:Add_wholesale_client.html");
	}
	
	private String generatePswd(int length) {
		
		 /*{
		        int length1 = 6; // password length
		        System.out.println(generatePswd(length1));
		    }*/
		   
		
		{
	        System.out.println("Your Password:");
	        String charsCaps = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	        String chars = "abcdefghijklmnopqrstuvwxyz";
	        String nums = "0123456789";
	        

	        String passSymbols = charsCaps + chars + nums;
	        Random rnd = new Random();
	         
	        int len = length;
			//char[] password = new char[len];
	        int index = 0;
	        for (int i = 0; i < len; i++) 
	        {
	            password += passSymbols.charAt(rnd.nextInt(passSymbols.length()));
	            
	        }
	       
	    }


		return password;
	}
	
	public static boolean empty( final String s ) 
	{
		return s == null || s.trim().isEmpty();
	}
	
	
	@RequestMapping(value="View_wholesale_client.html",method=RequestMethod.GET)
	public ModelAndView index12(@ModelAttribute Add_wholesale_client_VO  vo)
	
	
	{
		
		List ls=dao.search1(vo);
		return new ModelAndView("Admin/View_wholesale_client","list",ls);
	}
	
	@RequestMapping(value="deletewholesale.html",method=RequestMethod.GET)
	public ModelAndView delete(@RequestParam("id") int id, Add_wholesale_client_VO  vo,LoginVO lvo)
	{
		
	
		lvo.setLoginId(id);
		vo.setID(id);		
		dao.delete(vo);
		dao.delete(lvo);
			return new ModelAndView("redirect:View_wholesale_client.html");
	}
	
	@RequestMapping(value="editwholesale.html",method=RequestMethod.GET)
	public ModelAndView edit(@RequestParam("id") int id, Add_wholesale_client_VO vo)
	{
		vo.setID(id);
		List ls=dao.edit(vo);
		return new ModelAndView("Admin/Edit_wholesale_client","data",(Add_wholesale_client_VO)ls.get(0));
	}
	
	@RequestMapping(value="update_wholesale_client.html",method=RequestMethod.POST)
	public ModelAndView update(@ModelAttribute Add_wholesale_client_VO vo)
	{
		dao.update(vo);
		return new ModelAndView("redirect:View_wholesale_client.html");
		
	}
	
	
}

