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

@Repository
public class Add_wholesale_client_DAO {
	
	@Autowired
	SessionFactory sessionFactory;
	public Object i;
	
	public void insert(Add_wholesale_client_VO vo) {
		// TODO Auto-generated method stub
		try{
			Session session = sessionFactory.openSession();
			
			/*Query q1 = session.createQuery("select mobile from Add_wholesale_client_VO where mobile='"+vo.getMobile()+"'");
			i= q1.uniqueResult();*/
			
			Transaction tr = session.beginTransaction();
			session.saveOrUpdate(vo);
			tr.commit();
			session.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		
	}

	public List search1(Add_wholesale_client_VO vo) {
		Session session = sessionFactory.openSession();
		   
		Query q = session.createQuery("from Add_wholesale_client_VO");
		List ls = q.list();
	//	System.out.println(ls.get(0)); 
		session.close();
		return ls;
	}

	public void delete(Add_wholesale_client_VO vo,LoginVO lvo) {
		
		Session session = sessionFactory.openSession();
		
		Transaction tr = session.beginTransaction();
		session.delete(vo);
		tr.commit();
		// TODO Auto-generated method stub
		
	}

}
