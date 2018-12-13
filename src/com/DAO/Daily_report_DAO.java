package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Product_mon_retail_VO;

@Repository

public class Daily_report_DAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public List search() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Product_mon_retail_VO");
	//	Query q1 = session.createQuery("from Product_mon_wholesale_VO");

		List ls = q.list();
	//	List ls1=q1.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}
	

	
}
