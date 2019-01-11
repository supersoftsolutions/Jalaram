package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Regular_order")


public class RegularorderVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int regular_orderid;

	@Column
	private String Caterers_name;
	@Column
	private String Address;
	@Column
	private String Mobile;
	
	@Column
	private String Product;
	
	@Column
	private String Date;
	
	@Column
	private String Kg;
	
	@Column
	private String Rate;
	
	@Column
	private String Total;

	public int getRegular_orderid() {
		return regular_orderid;
	}

	public void setRegular_orderid(int regular_orderid) {
		this.regular_orderid = regular_orderid;
	}

	public String getCaterers_name() {
		return Caterers_name;
	}

	public void setCaterers_name(String caterers_name) {
		Caterers_name = caterers_name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getKg() {
		return Kg;
	}

	public void setKg(String kg) {
		Kg = kg;
	}

	public String getRate() {
		return Rate;
	}

	public void setRate(String rate) {
		Rate = rate;
	}

	public String getTotal() {
		return Total;
	}

	public void setTotal(String total) {
		Total = total;
	}

	
}
