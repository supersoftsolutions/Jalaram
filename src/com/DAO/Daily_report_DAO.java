package com.DAO;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.VO.Add_wholesale_client_VO;
import com.VO.Daily_report_VO;
import com.VO.Product_mon_retail_VO;
import com.VO.Product_mon_wholesale_VO;
import com.VO.Product_sun_retail_VO;
import com.VO.Product_sun_wholesale_VO;
import com.VO.Retail_client_VO;

@Repository

public class Daily_report_DAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public List search() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Daily_report_VO");
		List ls = q.list();
		session.close();
		return ls;
	}
	
	public void delete() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("delete from Daily_report_VO");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		tr.commit();
		session.close();
		
	}
	
	public void insert(Daily_report_VO vo,Product_mon_retail_VO mrvo,Retail_client_VO cvo,Product_mon_wholesale_VO mwvo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("insert into Daily_report_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,Date,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,rvo.name,rvo.priority,'2018-12-14',((rvo.idada*idada)+(rvo.khaman*khaman)+(rvo.khandvi*khandvi)+(rvo.nylon*nylon)+(rvo.patra*patra)+(rvo.sandwich_dhokla*sandwich_dhokla)+(rvo.sp_patra*sp_patra)) from Product_mon_retail_VO");
		Query q1 = session.createQuery("insert into Daily_report_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,Date,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,wvo.name,wvo.priority,'2018-12-14',((wvo.idada*idada)+(wvo.khaman*khaman)+(wvo.khandvi*khandvi)+(wvo.nylon*nylon)+(wvo.patra*patra)+(wvo.sandwich_dhokla*sandwich_dhokla)+(wvo.sp_patra*sp_patra)) from Product_mon_wholesale_VO");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		q1.executeUpdate();
		tr.commit();
		session.close();
		
	}
	
	public void insert(Daily_report_VO vo,Product_sun_retail_VO srvo,Add_wholesale_client_VO wvo,Product_sun_wholesale_VO swvo) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("insert into Daily_report_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,Date,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,rvo.name,rvo.priority,'2018-12-14',((rvo.idada*idada)+(rvo.khaman*khaman)+(rvo.khandvi*khandvi)+(rvo.nylon*nylon)+(rvo.patra*patra)+(rvo.sandwich_dhokla*sandwich_dhokla)+(rvo.sp_patra*sp_patra)) from Product_sun_retail_VO");
		Query q1 = session.createQuery("insert into Daily_report_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,Date,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,wvo.name,wvo.priority,'2018-12-14',((wvo.idada*idada)+(wvo.khaman*khaman)+(wvo.khandvi*khandvi)+(wvo.nylon*nylon)+(wvo.patra*patra)+(wvo.sandwich_dhokla*sandwich_dhokla)+(wvo.sp_patra*sp_patra)) from Product_sun_wholesale_VO");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		q1.executeUpdate();
		tr.commit();
		session.close();
		
	}
	
}
