package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.ProductRateVO;



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

}
