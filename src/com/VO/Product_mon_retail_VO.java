package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Product_mon_retail")
public class Product_mon_retail_VO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int productid;
	
	@ManyToOne
	private Retail_client_VO rvo;

	@Column
	private String patra;
	@Column
	private String khaman;
	@Column
	private String nylon;
	@Column
	private String idada;
	@Column
	private String khandvi;
	@Column
	private String sandwich_dhokla;
	@Column
	private String sp_patra;
	@Column
	private String samosa;
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public Retail_client_VO getRvo() {
		return rvo;
	}
	public void setRvo(Retail_client_VO rvo) {
		this.rvo = rvo;
	}
	public String getPatra() {
		return patra;
	}
	public void setPatra(String patra) {
		this.patra = patra;
	}
	public String getKhaman() {
		return khaman;
	}
	public void setKhaman(String khaman) {
		this.khaman = khaman;
	}
	public String getNylon() {
		return nylon;
	}
	public void setNylon(String nylon) {
		this.nylon = nylon;
	}
	public String getIdada() {
		return idada;
	}
	public void setIdada(String idada) {
		this.idada = idada;
	}
	public String getKhandvi() {
		return khandvi;
	}
	public void setKhandvi(String khandvi) {
		this.khandvi = khandvi;
	}
	public String getSandwich_dhokla() {
		return sandwich_dhokla;
	}
	public void setSandwich_dhokla(String sandwich_dhokla) {
		this.sandwich_dhokla = sandwich_dhokla;
	}
	public String getSp_patra() {
		return sp_patra;
	}
	public void setSp_patra(String sp_patra) {
		this.sp_patra = sp_patra;
	}
	public String getSamosa() {
		return samosa;
	}
	public void setSamosa(String samosa) {
		this.samosa = samosa;
	}
	
	

}
