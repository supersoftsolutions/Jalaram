package com.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.LoginVO;


@Repository
public class LoginDAO {

	@Autowired
	SessionFactory sessionFactory;

/*	public void insertReg(RegVO VO){
		
		try{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(VO);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		}*/

	public void insert(LoginVO loginVO) {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(loginVO);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		}
	}

