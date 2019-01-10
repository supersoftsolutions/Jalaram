package com.DAO;

import java.util.List;
import org.hibernate.SQLQuery;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Add_wholesale_client_VO;
import com.VO.Product_mon_retail_VO;
import com.VO.Product_mon_wholesale_VO;
import com.VO.Product_sun_retail_VO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Retail_client_VO;
import com.VO.Retail_product_VO;
import com.VO.Wholesale_product_VO;

@Repository
public class Sun_mon_product_DAO {

	@Autowired
	SessionFactory sessionFactory;

	public void insert(Product_sun_wholesale_VO svo) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(svo);
			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert1(Product_mon_wholesale_VO mvo) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(mvo);
			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void sun_retail(Product_sun_retail_VO svo) {
		// TODO Auto-generated method stub
		try {
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(svo);
			tr.commit();
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mon_retail(Product_mon_retail_VO mvo) {
		// TODO Auto-generated method stub
		try 
		{
			Session session = sessionFactory.openSession();
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(mvo);
			tr.commit();
			session.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	public void update(Product_mon_wholesale_VO mvo, Wholesale_product_VO vo) {
		Session session = sessionFactory.openSession();
		//Query q = session.createQuery("update Product_mon_wholesale_VO set " + vo.getProduct() + "='" + vo.getMon()+ "' where wvo_ID='" + mvo.getWvo().getID() + "'");
		Query q = session.createQuery("update Product_mon_wholesale_VO set "+vo.getProduct()+" = '" +vo.getMon()+"' where wvo = (select wvo from Wholesale_product_VO where productid='"+vo.getProductid()+"')");
		Transaction tr = session.beginTransaction();
		// session.update(q);
		q.executeUpdate();
		tr.commit();
		session.close();

	}

	public void update(Product_sun_wholesale_VO svo, Wholesale_product_VO vo) {
		Session session = sessionFactory.openSession();
		/*Query q = session.createQuery("update Product_sun_wholesale_VO set " + vo.getProduct() + "='" + vo.getSun()
				+ "' where wvo_ID='" + svo.getWvo().getID() + "'");*/
		Query q = session.createQuery("update Product_sun_wholesale_VO set "+vo.getProduct()+" = '" +vo.getSun()+"' where wvo = (select wvo from Wholesale_product_VO where productid='"+vo.getProductid()+"')");
		Transaction tr = session.beginTransaction();
		// session.update(q);
		q.executeUpdate();
		tr.commit();
		session.close();

	}

	public void edit(Product_mon_retail_VO mvo, Retail_product_VO vo) {
		Session session = sessionFactory.openSession();
		//Query q = session.createQuery("update Product_mon_retail_VO set "+vo.getProduct()+" = '" +vo.getMon()+"' where rvo_ID='" + mvo.getRvo().getID() + "'");
		Query q = session.createQuery("update Product_mon_retail_VO set "+vo.getProduct()+" = '" +vo.getMon()+"' where rvo = (select rvo from Retail_product_VO where productid='"+vo.getProductid()+"')");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();

	}

	public void edit1(Product_sun_retail_VO svo, Retail_product_VO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Product_sun_retail_VO set " + vo.getProduct() + " = '"+vo.getSun()+"' where rvo = (select rvo from Retail_product_VO where productid='"+vo.getProductid()+"')");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();

	}





	public void delete(Product_sun_wholesale_VO svo, Wholesale_product_VO vo,String s) {
		Session session = sessionFactory.openSession();
		//Query q = session.createQuery("update Product_sun_wholesale_VO set " + s + "='0' where wvo_ID='"+ vo.getWvo() + "'");
		Query q = session.createQuery("update Product_sun_wholesale_VO set "+s+" = '0' where wvo = (select wvo from Wholesale_product_VO where productid='"+vo.getProductid()+"')");
		Transaction tr = session.beginTransaction();
		 //session.update(q);
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	public void delete(Product_mon_wholesale_VO mvo, Wholesale_product_VO vo,String s) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Product_mon_wholesale_VO set "+s+" = '0' where wvo = (select wvo from Wholesale_product_VO where productid='"+vo.getProductid()+"')");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	
	public String get(Wholesale_product_VO vo) {

		Session session = sessionFactory.openSession();
		Query q1 = session.createQuery("select product from Wholesale_product_VO where productid='"+vo.getProductid()+"'");
		String i= (String)q1.uniqueResult();
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return i;
	}
	
	public String get(Retail_product_VO vo) {

		Session session = sessionFactory.openSession();
		Query q1 = session.createQuery("select product from Retail_product_VO where productid='"+vo.getProductid()+"'");
		String i= (String)q1.uniqueResult();
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return i;
	}


	public void delete(Product_sun_retail_VO rvo, Retail_product_VO vo,String s) {
		Session session = sessionFactory.openSession();
		//Query q = session.createQuery("update Product_sun_wholesale_VO set " + s + "='0' where wvo_ID='"+ vo.getWvo() + "'");
		Query q = session.createQuery("update Product_sun_retail_VO set "+s+" = '0' where rvo = (select rvo from Retail_product_VO where productid='"+vo.getProductid()+"')");
		Transaction tr = session.beginTransaction();
		 //session.update(q);
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	public void delete(Product_mon_retail_VO mvo, Retail_product_VO vo,String s) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Product_mon_retail_VO set "+s+" = '0' where rvo = (select rvo from Retail_product_VO where productid='"+vo.getProductid()+"')");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	public void delete(Retail_client_VO vo, Retail_product_VO svo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete from Retail_product_VO where rvo='"+vo.getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	public void delete(Retail_client_VO vo, Product_sun_retail_VO svo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete from Product_sun_retail_VO where rvo='"+vo.getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	public void delete(Retail_client_VO vo, Product_mon_retail_VO svo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete from Product_mon_retail_VO where rvo='"+vo.getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	
	public void delete(Add_wholesale_client_VO vo, Wholesale_product_VO svo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete from Wholesale_product_VO where wvo='"+vo.getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	public void delete(Add_wholesale_client_VO vo, Product_sun_wholesale_VO svo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete from Product_sun_wholesale_VO where wvo='"+vo.getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}
	
	public void delete(Add_wholesale_client_VO vo, Product_mon_wholesale_VO svo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete from Product_mon_wholesale_VO where wvo='"+vo.getID()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}

	
}
