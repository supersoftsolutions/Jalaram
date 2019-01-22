package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Order_purchase")



public class Order_purchaseVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderid;
	


	@Column
	private String Date;
	
	@Column
	private String Product;
	
	@Column
	private String rate;
	
	@Column
	private String Qty;
	
	@Column
	private String Total;
	
	
	@ManyToOne
	private Product_creditor_VO cvo;

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Product_creditor_VO getCvo() {
		return cvo;
	}

	public void setCvo(Product_creditor_VO cvo) {
		this.cvo = cvo;
	}
	
	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getQty() {
		return Qty;
	}

	public void setQty(String qty) {
		Qty = qty;
	}

	public String getTotal() {
		return Total;
	}

	public void setTotal(String total) {
		Total = total;
	}
	
	
	
	

}
