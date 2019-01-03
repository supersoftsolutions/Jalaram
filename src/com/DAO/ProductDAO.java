package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.ProductVO;

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


}
