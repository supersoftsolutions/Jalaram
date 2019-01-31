package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Material_purchaseVO;
import com.VO.Order_purchaseVO;
import com.VO.Product_creditor_VO;
import com.VO.PurchaseVO;
@Repository
public class PurchaseDAO {
	
	@Autowired
	SessionFactory sessionFactory;


	public void insert(PurchaseVO vo) {
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
		Query q = session.createQuery("from PurchaseVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}


	public void update(Product_creditor_VO pvo, PurchaseVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Product_creditor_VO set Balance=Balance+'"+vo.getTotal()+"' where purchaseid='"+vo.getPvo().getCreditorid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
		
	}


	public void insert(Material_purchaseVO vo) {
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


	public void insert(Order_purchaseVO vo) {
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
	
	public List search1(Product_creditor_VO pvo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("Select Rate from Product_creditor_VO where Product='"+pvo.getProduct()+"' and Name='"+pvo.getName()+"'");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}


	public List search1() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Order_purchaseVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}


	public List add(PurchaseVO pvo,Product_creditor_VO vo) {
		
		List ls=new ArrayList();
		{
			try
			{

				Session session=sessionFactory.openSession();
				Query q=session.createQuery("from Product_creditor_VO where product='"+vo.getName()+"'");
			//	Query query=session.createQuery(" FROM PurchaseVO WHERE vo IN (SELECT creditorid FROM  Product_creditor_VO WHERE product='"+vo.getProduct()+"')");

				ls=q.list();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			return ls;
		}
	}
}
