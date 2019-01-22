package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Purchase")

public class PurchaseVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int purchaseid;
	
	@Column
	private String Product;
	
	@Column
	private String Qty;
	
	@Column
	private String Rate;
	
	@Column
	private String Total;
	
	@Column
	private String Name;
	
	@Column
	private String Date;
	
	@ManyToOne
	private Product_creditor_VO pvo;

	public int getPurchaseid() {
		return purchaseid;
	}

	public void setPurchaseid(int purchaseid) {
		this.purchaseid = purchaseid;
	}

	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public String getQty() {
		return Qty;
	}

	public void setQty(String qty) {
		Qty = qty;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public Product_creditor_VO getPvo() {
		return pvo;
	}

	public void setPvo(Product_creditor_VO pvo) {
		this.pvo = pvo;
	}

	
	
	
	
	

}
