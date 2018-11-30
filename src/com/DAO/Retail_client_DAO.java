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

<<<<<<< HEAD
=======

	public List edit(Retail_client_VO vo) {
		List ls=new ArrayList();
		Session session=sessionFactory.openSession();
		Query q = session.createQuery("from Retail_client_VO where id='"+vo.getID()+"'");
		ls = q.list();
		return ls;
	}

	public void update(Retail_client_VO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		Query q = session.createQuery("update Retail_client_VO set address1='"+vo.getAddress1()+"',address2='"+vo.getAddress2()+"',address3='"+vo.getAddress3()+"',idada='"+vo.getIdada()+"',khaman='"+vo.getKhaman()+"',khandvi='"+vo.getKhandvi()+"',nylon='"+vo.getNylon()+"',patra='"+vo.getPatra()+"',priority='"+vo.getPriority()+"',samosa='"+vo.getSamosa()+"',sandwich_dhokla='"+vo.getSandwich_dhokla()+"',sp_patra='"+vo.getSp_patra()+"',id='"+vo.getID()+"'");
		q.executeUpdate();		
		
			tr.commit();
		
	}
>>>>>>> 8a6726e461b39c1508ebbc4a26affbd716e3af40
}
