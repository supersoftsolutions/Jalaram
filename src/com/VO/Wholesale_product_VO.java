package com.VO;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Wholesale_product")

public class Wholesale_product_VO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;

	@Column
	private String product;
	@Column
	private String mon;
	@Column
	private String sun;
	
	@ManyToOne
	private Add_wholesale_client_VO wvo;

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getMon() {
		return mon;
	}

	public void setMon(String mon) {
		this.mon = mon;
	}

	public String getSun() {
		return sun;
	}

	public void setSun(String sun) {
		this.sun = sun;
	}

	public Add_wholesale_client_VO getWvo() {
		return wvo;
	}

	public void setWvo(Add_wholesale_client_VO wvo) {
		this.wvo = wvo;
	}
	
	


}
