package com.VO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Product_rate")

public class ProductRateVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;

	@Column
	private String Rate;
	
	@Column
	private String Product;

	
	@ManyToOne
	private CaterersVO cvo;

/*	@ManyToOne
	private ProductVO pvo;*/
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	
	
	public String getRate() {
		return Rate;
	}
	public void setRate(String rate) {
		Rate = rate;
	}
	
	
	

	public String getProduct() {
		return Product;
	}
	public void setProduct(String product) {
		Product = product;
	}
	public CaterersVO getCvo() {
		return cvo;
	}
	public void setCvo(CaterersVO cvo) {
		this.cvo = cvo;
	}
/*	public ProductVO getPvo() {
		return pvo;
	}
	public void setPvo(ProductVO pvo) {
		this.pvo = pvo;
	}*/
	
	
	
	
	

}
