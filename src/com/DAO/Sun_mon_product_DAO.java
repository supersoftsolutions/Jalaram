package com.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Product_mon_wholesale_VO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Retail_client_VO;

@Repository
public class Sun_mon_product_DAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void insert(Product_sun_wholesale_VO svo) {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(svo);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		}
	
	public void insert1(Product_mon_wholesale_VO mvo) {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(mvo);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		}
}
