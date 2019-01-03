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
import com.VO.Daily_report1_VO;
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

	public List<Daily_report_VO> search() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Daily_report_VO");
		List<Daily_report_VO> ls = q.list();
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
	
	public void insert(Daily_report_VO vo,Product_mon_retail_VO mrvo,Retail_client_VO cvo,Product_mon_wholesale_VO mwvo,String s) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("insert into Daily_report_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,rvo.name,rvo.priority,((rvo.idada*idada)+(rvo.khaman*khaman)+(rvo.khandvi*khandvi)+(rvo.nylon*nylon)+(rvo.patra*patra)+(rvo.sandwich_dhokla*sandwich_dhokla)+(rvo.sp_patra*sp_patra)) from Product_mon_retail_VO");
		Query q1 = session.createQuery("insert into Daily_report_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,wvo.name,wvo.priority,((wvo.idada*idada)+(wvo.khaman*khaman)+(wvo.khandvi*khandvi)+(wvo.nylon*nylon)+(wvo.patra*patra)+(wvo.sandwich_dhokla*sandwich_dhokla)+(wvo.sp_patra*sp_patra)) from Product_mon_wholesale_VO");
		Query q2 = session.createQuery("update Daily_report_VO set Date='"+s+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		q1.executeUpdate();
		q2.executeUpdate();
		tr.commit();
		session.close();
		
	}
	
	public void insert(Daily_report_VO vo,Product_sun_retail_VO srvo,Add_wholesale_client_VO wvo,Product_sun_wholesale_VO swvo,String s) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("insert into Daily_report_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,rvo.name,rvo.priority,((rvo.idada*idada)+(rvo.khaman*khaman)+(rvo.khandvi*khandvi)+(rvo.nylon*nylon)+(rvo.patra*patra)+(rvo.sandwich_dhokla*sandwich_dhokla)+(rvo.sp_patra*sp_patra)) from Product_sun_retail_VO");
		Query q1 = session.createQuery("insert into Daily_report_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,wvo.name,wvo.priority,((wvo.idada*idada)+(wvo.khaman*khaman)+(wvo.khandvi*khandvi)+(wvo.nylon*nylon)+(wvo.patra*patra)+(wvo.sandwich_dhokla*sandwich_dhokla)+(wvo.sp_patra*sp_patra)) from Product_sun_wholesale_VO");
		Query q2 = session.createQuery("update Daily_report_VO set Date='"+s+"'");
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
		q1.executeUpdate();
		q2.executeUpdate();
		tr.commit();
		session.close();
		
	}

	public List edit(Daily_report_VO dvo) {
		
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Daily_report_VO where iD='" + dvo.getID() + "'");
		List ls = q.list();
		session.close();
		return ls;
	}
	
	public void insert(Daily_report1_VO vo) {
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
	public void insert3(Daily_report_VO dvo,String s) {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("update Daily_report_VO set idada='"+dvo.getIdada()+"',khaman='"+dvo.getKhaman()+"',khandvi='"+dvo.getKhandvi()+"',nylon='"+dvo.getNylon()+"',patra='"+dvo.getPatra()+"',samosa='"+dvo.getSamosa()+"',sandwich_dhokla='"+dvo.getSandwich_dhokla()+"',sp_patra='"+dvo.getSp_patra()+"' where ID='"+dvo.getID()+"'");

	//	Query q = session.createQuery("insert into Daily_report1_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,rvo.name,rvo.priority,((rvo.idada*idada)+(rvo.khaman*khaman)+(rvo.khandvi*khandvi)+(rvo.nylon*nylon)+(rvo.patra*patra)+(rvo.sandwich_dhokla*sandwich_dhokla)+(rvo.sp_patra*sp_patra)) from Product_sun_retail_VO");
	//	Query q1 = session.createQuery("insert into Daily_report1_VO (idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total) select idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,wvo.name,wvo.priority,((wvo.idada*idada)+(wvo.khaman*khaman)+(wvo.khandvi*khandvi)+(wvo.nylon*nylon)+(wvo.patra*patra)+(wvo.sandwich_dhokla*sandwich_dhokla)+(wvo.sp_patra*sp_patra)) from Product_sun_wholesale_VO");
		Query q2 = session.createQuery("update Daily_report_VO set Date='"+s+"'");
	//	Query query = session.createQuery("insert into Daily_report1_VO (Date,idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total)" +
    	//		"select Date,idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total from Daily_report_VO");
	
		
	//	Query query1 = session.createQuery("update Daily_report1_VO set (Date,idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total)"  +
    //			"select Date,idada,khaman,khandvi,nylon,patra,samosa,sandwich_dhokla,sp_patra,name,priority,total from Daily_report_VO");
	
		
		Transaction tr = session.beginTransaction();
		q.executeUpdate();
	//	q1.executeUpdate();
		q2.executeUpdate();
		//query.executeUpdate();
		//query1.executeUpdate();
		tr.commit();	
		session.close();
		
	}
	
	public List search1() {
		Session session = sessionFactory.openSession();
		Query q = session.createQuery("from Daily_report1_VO");
		List ls1 = q.list();
		session.close();
		return ls1;
	}
	
	public String get(Daily_report_VO dvo) {

		Session session = sessionFactory.openSession();
		Query q1 = session.createQuery("select Date from Daily_report_VO where Date='"+dvo.getID()+"'");
		String i= (String)q1.uniqueResult();
		Transaction tr = session.beginTransaction();
		tr.commit();
		session.close();
		return i;
	}
	

}
