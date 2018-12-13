package com.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Add_wholesale_client_VO;
import com.VO.Retail_client_VO;
import com.VO.Retail_product_VO;
import com.VO.Wholesale_product_VO;

@Repository
public class Retail_client_DAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void insert(Retail_client_VO vo) {
		// TODO Auto-generated method stub
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
		Query q = session.createQuery("from Retail_client_VO");
		List ls = q.list();
		session.close();
		return ls;
		
	}

	public void delete(Retail_client_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		// TODO Auto-generated method stub
	}

	public List edit(Retail_client_VO vo) {
		Session session=sessionFactory.openSession();
		Query q = session.createQuery("from Retail_client_VO where id='"+vo.getID()+"'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update(Retail_client_VO vo)
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(vo);
		tr.commit();
		session.close();
	}

	public void product(Retail_product_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(vo);
		tr.commit();
		session.close();
		
	}

	public List search() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Retail_product_VO");
		List ls = q.list();
	//	session.close();
		return ls;
	}

	public void delete(Retail_product_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();		
	}

	public List edit(Retail_product_VO vo) {
		Session session=sessionFactory.openSession();
		Query q = session.createQuery("from Retail_product_VO where id='"+vo.getProductid()+"'");
		List ls = q.list();
		//session.close();
		return ls;
	}

	public void update1(Retail_product_VO vo) {
		/*Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(vo);
		tr.commit();
		session.close();*/
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Retail_product_VO set mon='"+vo.getMon()+"',sun='"+vo.getSun()+"' where productid='"+vo.getProductid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
}