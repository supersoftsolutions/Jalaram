package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Add_wholesale_client_VO;
import com.VO.ProductRateVO;
import com.VO.RegularorderVO;
import com.VO.TransportVO;
import com.VO.Wholesale_product_VO;



@Repository



public class LiveCounterDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public void insert(ProductRateVO vo) {
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
		Query q = session.createQuery("from ProductRateVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(ProductRateVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();		
	}

	public List edit(ProductRateVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from ProductRateVO where id='" + vo.getID() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(ProductRateVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update ProductRateVO set Rate='"+vo.getRate()+"' where id='"+vo.getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();		
		
	}

	public void insert(RegularorderVO vo) {
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

	public List search1() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from RegularorderVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(RegularorderVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();				
	}

	public List edit(RegularorderVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from RegularorderVO where id='" + vo.getRegular_orderid() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(RegularorderVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update RegularorderVO set Kg='"+vo.getKg()+"',Rate='"+vo.getRate()+"',Total='"+vo.getTotal()+"' where id='"+vo.getRegular_orderid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();				
	}
	
	public String insert1(RegularorderVO vo) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();

		
		 Query q1 = session.createQuery("select Status from RegularorderVO where id='"+vo.getRegular_orderid()+"'"); 
		 String i= (String) q1.uniqueResult();
		
		Transaction tr = session.beginTransaction();
		//session.saveOrUpdate(vo);
		tr.commit();
		session.close();
		return i;

	}

	public List search2(RegularorderVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from RegularorderVO where Status='pending'");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}



	public void update(RegularorderVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update RegularorderVO set Status='cancel' where id='"+vo.getRegular_orderid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();				
	}
	
	public String get(TransportVO vo) {

		Session session = sessionFactory.openSession();
		Query q1 = session.createQuery("select charges from TransportVO where transportid='"+vo.getTransportid()+"'");
		String i= (String)q1.uniqueResult();
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return i;
	}
	
	

	public List search13(TransportVO vo, String m) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from TransportVO where id='" +m+ "'");
		List ls = q.list();
		session.close();
		return ls;
	}

}
