package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Product_mon_retail_VO;
import com.VO.Product_mon_wholesale_VO;
import com.VO.Product_sun_retail_VO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Retail_client_VO;
import com.VO.Retail_product_VO;

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
	
	public void sun_retail(Product_sun_retail_VO svo) {
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
	
	public void mon_retail(Product_mon_retail_VO mvo) {
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
	
	public void update(Product_mon_wholesale_VO mvo)
	{
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		session.update(mvo);
		tr.commit();
		session.close();
	}
	
	public void update(Product_sun_wholesale_VO svo)
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(svo);
		tr.commit();
		session.close();
	}
	
	public void edit(Product_mon_retail_VO mvo,Retail_product_VO vo) {
		Session session=sessionFactory.openSession();
		Query q = session.createQuery("update Product_mon_retail_VO set "+vo.getProduct()+"='"+vo.getMon()+"'");
		Transaction tr = session.beginTransaction();
		session.update(q);
		tr.commit();
		
	}
	
	
}
