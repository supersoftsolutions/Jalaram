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
	private Product_mon_retail_VO rmvo;
	
	@ManyToOne
	private Product_sun_retail_VO rsvo;
	
	@ManyToOne
	private Product_mon_wholesale_VO wmvo;
	
	@ManyToOne
	private Product_sun_wholesale_VO wmsvo;

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public Product_mon_retail_VO getRmvo() {
		return rmvo;
	}

	public void setRmvo(Product_mon_retail_VO rmvo) {
		this.rmvo = rmvo;
	}

	public Product_sun_retail_VO getRsvo() {
		return rsvo;
	}

	public void setRsvo(Product_sun_retail_VO rsvo) {
		this.rsvo = rsvo;
	}

	public Product_mon_wholesale_VO getWmvo() {
		return wmvo;
	}

	public void setWmvo(Product_mon_wholesale_VO wmvo) {
		this.wmvo = wmvo;
	}

	public Product_sun_wholesale_VO getWmsvo() {
		return wmsvo;
	}

	public void setWmsvo(Product_sun_wholesale_VO wmsvo) {
		this.wmsvo = wmsvo;
	}
	
	

}
