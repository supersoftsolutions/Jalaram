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
	private String name;
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
	private String priority;
	@Column
	private String total;
	
	
	@Override
    public String toString() {
        return "Daily_report_VO [name=" + name + ", Date=" + Date + ", patra=" + patra + ", khaman=" + khaman + ", nylon=" + nylon + ", idada=" + idada + ", khandvi=" + khandvi + ", sandwich_dhokla=" + sandwich_dhokla + ", sp_patra=" + sp_patra + ", samosa=" + samosa + ", priority=" + priority + ", total=" + total + "]";
    }
	
	/*public Daily_report_VO() {
		
	}*/
	
	
	/*public Daily_report_VO(int iD, String name, String date, String patra, String khaman, String nylon, String idada,
			String khandvi, String sandwich_dhokla, String sp_patra, String samosa, String priority, String total) {
		super();
		ID = iD;
		this.name = name;
		Date = date;
		this.patra = patra;
		this.khaman = khaman;
		this.nylon = nylon;
		this.idada = idada;
		this.khandvi = khandvi;
		this.sandwich_dhokla = sandwich_dhokla;
		this.sp_patra = sp_patra;
		this.samosa = samosa;
		this.priority = priority;
		this.total = total;
	}*/
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	
	
	
	

}
