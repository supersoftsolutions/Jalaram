package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Labour")


public class LabourVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int labourid;

	@Column
	private String Name;
	@Column
	private String Address;
	@Column
	private String Mobile;
	@Column
	private String Charges;
	
	@Column
	private String Balance;

	public int getLabourid() {
		return labourid;
	}

	public void setLabourid(int labourid) {
		this.labourid = labourid;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getCharges() {
		return Charges;
	}

	public void setCharges(String charges) {
		Charges = charges;
	}

	public String getBalance() {
		return Balance;
	}

	public void setBalance(String balance) {
		Balance = balance;
	}
	
	

}
