package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Row_Material_purchase")


public class Row_Material_purchase_VO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseid;

	@Column
	private String Date;
	@Column
	private String Stock;
	
	
	@ManyToOne
	private Row_Material_VO wvo;


	public int getPurchaseid() {
		return purchaseid;
	}


	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}


	public String getDate() {
		return Date;
	}


	public void setDate(String date) {
		Date = date;
	}


	public String getStock() {
		return Stock;
	}


	public void setStock(String stock) {
		Stock = stock;
	}


	public Row_Material_VO getWvo() {
		return wvo;
	}


	public void setWvo(Row_Material_VO wvo) {
		this.wvo = wvo;
	}
	
	

	
	
}
