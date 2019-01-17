package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Live_order")


public class LiveorderVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int live_orderid;
	
	@Column
	private String caterers_name;
	
	@Column
	private String product;


	@Column
	private String Address;
	
	@Column
	private String Date;
	
	@Column
	private String Time;
	
	@Column
	private String Kg;
	
	@Column
	private String Rate;
	
	@Column
	private String Total;
	
	@Column
	private String Status;
	
	@Column
	private String Transport_name;
	
	@Column
	private String Transport_charge;
	
	@Column
	private String Labour_charge;
	
	@Column
	private String Transport_type;
	
	
	public int getLive_orderid() {
		return live_orderid;
	}

	public void setLive_orderid(int live_orderid) {
		this.live_orderid = live_orderid;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}
	
	

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
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

	
	
	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getTransport_name() {
		return Transport_name;
	}

	public void setTransport_name(String transport_name) {
		Transport_name = transport_name;
	}

	public String getTransport_charge() {
		return Transport_charge;
	}

	public void setTransport_charge(String transport_charge) {
		Transport_charge = transport_charge;
	}

	public String getLabour_charge() {
		return Labour_charge;
	}

	public void setLabour_charge(String labour_charge) {
		Labour_charge = labour_charge;
	}

	public String getTransport_type() {
		return Transport_type;
	}

	public void setTransport_type(String transport_type) {
		Transport_type = transport_type;
	}

	

	public String getCaterers_name() {
		return caterers_name;
	}

	public void setCaterers_name(String caterers_name) {
		this.caterers_name = caterers_name;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	
	
	

}
