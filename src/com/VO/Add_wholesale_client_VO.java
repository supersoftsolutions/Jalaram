package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.VO.LoginVO;

@Entity
@Table(name = "Wholesale_client")
public class Add_wholesale_client_VO {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String name;
	@Column
	private String address1;
	@Column
	private String address2;
	@Column
	private String mobile;
	@Column
	private String priority;
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
	private String password;
	@Column
	private String balance;
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	@ManyToOne
	private LoginVO lvo;
   
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginVO getLvo() {
		return lvo;
	}
	public void setLvo(LoginVO lvo) {
		this.lvo = lvo;
	}

	
	
}
