package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class Daily_report_DAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public List search() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Daily_report1_VO");
		List ls = q.list();
		// System.out.println(ls.get(0));
		session.close();
		return ls;
	}

}
