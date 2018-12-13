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
import com.VO.Product_mon_wholesale_VO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Retail_product_VO;
import com.VO.Wholesale_product_VO;

@Repository
public class Add_wholesale_client_DAO {

	@Autowired
	SessionFactory sessionFactory;
	public Object i;

	public void insert(Add_wholesale_client_VO vo) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();

		/*
		 * Query q1 = session.
		 * createQuery("select mobile from Add_wholesale_client_VO where mobile='"
		 * +vo.getMobile()+"'"); i= q1.uniqueResult();
		 */

		Transaction tr = session.beginTransaction();
		session.saveOrUpdate(vo);
		tr.commit();
		session.close();

	}
	
	public String insert1(Add_wholesale_client_VO vo) {
		// TODO Auto-generated method stub

		Session session = sessionFactory.openSession();

		
		 Query q1 = session.createQuery("select mobile from Add_wholesale_client_VO where mobile='"+vo.getMobile()+"'"); 
		 String i= (String) q1.uniqueResult();
		
		Transaction tr = session.beginTransaction();
		//session.saveOrUpdate(vo);
		tr.commit();
		session.close();
		return i;

	}

	public List search1() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Add_wholesale_client_VO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	

	

	/*
	 * public void delete1(LoginVO lvo) {
	 * 
	 * Session session = sessionFactory.openSession();
	 * 
	 * 
	 * Transaction tr = session.beginTransaction(); session.delete(lvo);
	 * 
	 * tr.commit(); // TODO Auto-generated method stub
	 * 
	 * }
	 */

	public List edit(Add_wholesale_client_VO vo) {

		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Add_wholesale_client_VO where id='" + vo.getID() + "'");
		List ls = q.list();
		session.close();
		return ls;

	}

	public void update(Add_wholesale_client_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(vo);
		tr.commit();
		session.close();
	}

	public void product(Wholesale_product_VO vo) {
		Session session = sessionFactory.openSession();

		/*
		 * Query q1 = session.
		 * createQuery("select mobile from Add_wholesale_client_VO where mobile='"
		 * +vo.getMobile()+"'"); i= q1.uniqueResult();
		 */

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
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Wholesale_product_VO where id='" + vo.getProductid() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	
	public void delete(LoginVO lvo,Add_wholesale_client_VO vo,String m) {
		Session session = sessionFactory.openSession();
		//Query q = session.createQuery("update Product_sun_wholesale_VO set " + s + "='0' where wvo_ID='"+ vo.getWvo() + "'");
		Query q = session.createQuery("delete from LoginVO where userName = '"+m+"'");
		Transaction tr = session.beginTransaction();
		 //session.update(q);
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	public void delete(Add_wholesale_client_VO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete from Add_wholesale_client_VO where ID ='"+vo.getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	public String get(Add_wholesale_client_VO vo) {

		Session session = sessionFactory.openSession();
		Query q1 = session.createQuery("select mobile from Add_wholesale_client_VO where ID='"+vo.getID()+"'");
		String i= (String)q1.uniqueResult();
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return i;
	}
	
	public void update1(Wholesale_product_VO vo) {

		/*Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(vo);
		tr.commit();
		session.close();*/
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Wholesale_product_VO set mon='"+vo.getMon()+"',sun='"+vo.getSun()+"' where productid='"+vo.getProductid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();

	}

}
