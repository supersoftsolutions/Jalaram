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

	public List search1(Retail_client_VO vo) {
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

}

