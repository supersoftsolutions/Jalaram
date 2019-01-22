package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Material_purchase")


public class Material_purchaseVO {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int materialid;
	
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
	
	@Column
	private String Labour_charge;

	public int getMaterialid() {
		return materialid;
	}

	public void setMaterialid(int materialid) {
		this.materialid = materialid;
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

	public String getLabour_charge() {
		return Labour_charge;
	}

	public void setLabour_charge(String labour_charge) {
		Labour_charge = labour_charge;
	}
	
	
	

}
