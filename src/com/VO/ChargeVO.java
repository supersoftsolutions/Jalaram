package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Caterers_detail")

public class ChargeVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;

	@Column
	private String L_name;	
	
	@Column
	private String L_charge;
	
	@ManyToOne
	private TransportVO tvo;
	
	public TransportVO getTvo() {
		return tvo;
	}
	public void setTvo(TransportVO tvo) {
		this.tvo = tvo;
	}

	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getL_name() {
		return L_name;
	}
	public void setL_name(String l_name) {
		L_name = l_name;
	}
	public String getL_charge() {
		return L_charge;
	}
	public void setL_charge(String l_charge) {
		L_charge = l_charge;
	}
	
	

}
