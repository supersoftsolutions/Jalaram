package com.DAO;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.AccountVO;
import com.VO.Extra_hoursVO;
import com.VO.LabourVO;
import com.VO.MiscellaneousVO;
import com.VO.Row_Material_VO;
import com.VO.Row_Material_purchase_VO;
import com.VO.StaffVO;
import com.VO.Staff_leaveVO;
import com.VO.TransportVO;



@Repository
public class StaffDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public void insert(Staff_leaveVO vo) {
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
		Query q = session.createQuery("from Staff_leaveVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(Staff_leaveVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();		
	}

	public void insert(Extra_hoursVO vo) {
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

	public void update(StaffVO svo, Extra_hoursVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update StaffVO set Balance=Balance+'"+vo.getAmount()+"' where staffid='"+vo.getSvo().getStaffid()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
		
	}

	public List search12() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Extra_hoursVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(Extra_hoursVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();			
	}
	
	public void update1(StaffVO svo, Extra_hoursVO vo,String m,int id) {
		Session session = sessionFactory.openSession();
		//Query q = session.createQuery("update Row_Material_VO set Stock=Stock-'"+m+"' where ID='"+vo.getWvo().getID()+"'");
		Query q = session.createQuery("update StaffVO set Balance=Balance-'"+m+"' where staffid = (select svo from Extra_hoursVO where extra_hoursid='"+id+"')");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
	}

	public String get(Extra_hoursVO vo) {

		Session session = sessionFactory.openSession();
		Query q1 = session.createQuery("select Amount from Extra_hoursVO where extra_hoursid='"+vo.getExtra_hoursid()+"'");
		String i= (String)q1.uniqueResult();
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return i;
	}

	public void insert(MiscellaneousVO vo) {
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

	public List search2() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from MiscellaneousVO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

	public void delete(MiscellaneousVO vo) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		session.close();			
	}

	public List edit(MiscellaneousVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from MiscellaneousVO where id='" + vo.getId() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}

	public void update1(MiscellaneousVO vo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update MiscellaneousVO set Address='"+vo.getAddress()+"',Description='"+vo.getDescription()+"' where id='"+vo.getId()+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();		
	}
	
}
