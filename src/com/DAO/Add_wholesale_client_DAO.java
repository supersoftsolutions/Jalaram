package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Add_wholesale_client_VO;
import com.VO.LoginVO;
import com.VO.Wholesale_product_VO;

@Repository
public class Add_wholesale_client_DAO {
	
	@Autowired
	SessionFactory sessionFactory;
	public Object i;
	
	public void insert(Add_wholesale_client_VO vo) {
		// TODO Auto-generated method stub
	
			Session session = sessionFactory.openSession();
			
			/*Query q1 = session.createQuery("select mobile from Add_wholesale_client_VO where mobile='"+vo.getMobile()+"'");
			i= q1.uniqueResult();*/
			
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(vo);
			tr.commit();
			session.close();
		
		
	}

	public List search1() {
		Session session = sessionFactory.openSession();
		   
		Query q = session.createQuery("from Add_wholesale_client_VO");
		List ls = q.list();
	//	System.out.println(ls.get(0)); 
		session.close();
		return ls;
	}

	public void delete(Add_wholesale_client_VO vo)
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
	}
	
	public void delete(LoginVO lvo)
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(lvo);
		tr.commit();
		session.close();
	}
	
/*public void delete1(LoginVO lvo) {
		
		Session session = sessionFactory.openSession();
		

		Transaction tr = session.beginTransaction();
		session.delete(lvo);
		
		tr.commit();
		// TODO Auto-generated method stub
		
	}*/
	
	public List edit(Add_wholesale_client_VO vo)
	{
	
		Session session=sessionFactory.openSession();
		Query q = session.createQuery("from Add_wholesale_client_VO where id='"+vo.getID()+"'");
		List ls = q.list();
		session.close();
		return ls;
		
	}
	public void update(Add_wholesale_client_VO vo)
	{
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(vo);
		tr.commit();
		session.close();
	}

	public void product(Wholesale_product_VO vo) {
		Session session = sessionFactory.openSession();
		
		/*Query q1 = session.createQuery("select mobile from Add_wholesale_client_VO where mobile='"+vo.getMobile()+"'");
		i= q1.uniqueResult();*/
		
		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(vo);
		tr.commit();
		session.close();
	
		
	}

	public List search() {
		
			
			Session session = sessionFactory.openSession();
			Query q = session.createQuery("from Wholesale_product_VO");
			List ls = q.list();
			session.close();
			return ls;
		}

	public void delete(Wholesale_product_VO vo) {
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
		// TODO Auto-generated method stub
		
	}

	public List edit(Wholesale_product_VO vo) {
		Session session=sessionFactory.openSession();
		Query q = session.createQuery("from Wholesale_product_VO where id='"+vo.getProductid()+"'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(Wholesale_product_VO vo) {
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(vo);
		tr.commit();
		session.close();
		
	}
	}
	
	

	


