package com.VO;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Daily_report_temp")

public class Daily_report_VO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	
	@Column
	private String Date;
	
	
	
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
	@Column
	private String total;
	
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
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
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	
	

}
