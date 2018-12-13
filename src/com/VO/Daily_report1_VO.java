package com.VO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Daily_report")


public class Daily_report1_VO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	@ManyToOne
	private Add_wholesale_client_VO wvo;

}
