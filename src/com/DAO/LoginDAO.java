package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.LoginVO;
import com.VO.Row_Material_VO;
import com.VO.Row_Material_purchase_VO;
import com.VO.Wholesale_product_VO;


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

	public void insert(Row_Material_VO vo) {
		try{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(vo);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}

	public List search() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Row_Material_VO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(Row_Material_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
		
	}

	public void insert(Row_Material_purchase_VO vo) {
		try{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(vo);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	public void update(Row_Material_VO rvo, Row_Material_purchase_VO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Row_Material_VO set Stock=Stock+'"+vo.getStock()+"' where ID='"+vo.getWvo().getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
		
	}

	public List search1() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Row_Material_purchase_VO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(Row_Material_purchase_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
				
	}

	public void update1(Row_Material_VO rvo, Row_Material_purchase_VO vo,String m) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Row_Material_VO set Stock=Stock-'"+m+"' where ID='"+vo.getWvo().getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
		
	}
	
	public String get(Row_Material_purchase_VO vo) {

		Session session = sessionFactory.openSession();
		Query q1 = session.createQuery("select Stock from Row_Material_purchase_VO where purchaseid='"+vo.getPurchaseid()+"'");
		String i= (String)q1.uniqueResult();
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return i;
	}
	}
	

