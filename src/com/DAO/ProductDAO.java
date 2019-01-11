package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.CaterersVO;
import com.VO.ProductVO;
import com.VO.Row_Material_VO;
import com.VO.StaffVO;

@Repository


public class ProductDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public void insert(ProductVO vo) {
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
		Query q = session.createQuery("from ProductVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(ProductVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
		
	}

	public void insert(StaffVO vo) {
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
		Query q = session.createQuery("from StaffVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(StaffVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
	}

	public List edit(StaffVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from StaffVO where staffid='" + vo.getStaffid() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(StaffVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update StaffVO set Address='"+vo.getAddress()+"',Mobile='"+vo.getMobile()+"',Salary='"+vo.getSalary()+"' where staffid='"+vo.getStaffid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();		
	}

	public void insert(CaterersVO vo) {
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

	public List search2() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from CaterersVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(CaterersVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
		
	}

	public List edit(CaterersVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from CaterersVO where caterersid='" + vo.getCaterersid() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(CaterersVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update CaterersVO set Address='"+vo.getAddress()+"',Mobile='"+vo.getMobile()+"' where caterersid='"+vo.getCaterersid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}


}
