package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.AccountVO;
import com.VO.LabourVO;
import com.VO.TransportVO;



@Repository
public class LabourDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public void insert(LabourVO vo) {
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
		Query q = session.createQuery("from LabourVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(LabourVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();
		
	}

	public List edit(LabourVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from LabourVO where labourid='" + vo.getLabourid() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(LabourVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update LabourVO set Address='"+vo.getAddress()+"',Mobile='"+vo.getMobile()+"',Charges='"+vo.getCharges()+"' where labourid='"+vo.getLabourid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
		
	}

	public void insert(TransportVO vo) {
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

	public List search1() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from TransportVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(TransportVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();		
	}

	public List edit(TransportVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from TransportVO where transportid='" + vo.getTransportid() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(TransportVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update TransportVO set Address='"+vo.getAddress()+"',Mobile='"+vo.getMobile()+"',Charges='"+vo.getCharges()+"' where transportid='"+vo.getTransportid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();		
	}

	public void insert(AccountVO vo) {
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

	public List search12() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from AccountVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(AccountVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();				
	}

	public List edit(AccountVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from AccountVO where accountid='" + vo.getAccountid() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(AccountVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update AccountVO set No='"+vo.getNo()+"',B_name='"+vo.getB_name()+"',IFSC='"+vo.getIFSC()+"',Balance='"+vo.getBalance()+"' where accountid='"+vo.getAccountid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();				
	}

}
