package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Material_creditor_VO;
import com.VO.Product_creditor_VO;
@Repository
public class CreditorDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public void insert(Product_creditor_VO vo) {
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
		Query q = session.createQuery("from Product_creditor_VO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(Product_creditor_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
	}

	public List edit(Product_creditor_VO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Product_creditor_VO where creditorid='" + vo.getCreditorid() + "'");
		List ls = q.list();
		session.close();
		return ls;

	}

	public void update1(Product_creditor_VO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Product_creditor_VO set Address='"+vo.getAddress()+"',Mobile='"+vo.getMobile()+"',Rate='"+vo.getRate()+"' where creditorid='"+vo.getCreditorid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
		
	}

	public void insert(Material_creditor_VO vo) {
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
		Query q = session.createQuery("from Material_creditor_VO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public List edit(Material_creditor_VO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Material_creditor_VO where creditorid='" + vo.getCreditorid() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(Material_creditor_VO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Material_creditor_VO set Address='"+vo.getAddress()+"',Mobile='"+vo.getMobile()+"' where creditorid='"+vo.getCreditorid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
		
	}

	public void delete(Material_creditor_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();		
	}

}
