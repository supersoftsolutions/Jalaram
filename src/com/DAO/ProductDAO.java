package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.ProductVO;
import com.VO.Row_Material_VO;

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


}
