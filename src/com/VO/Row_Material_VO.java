package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Row_Material")

public class Row_Material_VO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String Product_name;
	
	@Column
	private String Stock;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getProduct_name() {
		return Product_name;
	}
	public void setProduct_name(String product_name) {
		Product_name = product_name;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	
	
	
}
