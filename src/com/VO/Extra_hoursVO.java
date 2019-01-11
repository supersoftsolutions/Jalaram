package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Extra_hours")

public class Extra_hoursVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int extra_hoursid;
	
	@Column
	private String Date;

	@Column
	private String Amount;
	
	@ManyToOne
	private StaffVO svo;

	public int getExtra_hoursid() {
		return extra_hoursid;
	}

	public void setExtra_hoursid(int extra_hoursid) {
		this.extra_hoursid = extra_hoursid;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public StaffVO getSvo() {
		return svo;
	}

	public void setSvo(StaffVO svo) {
		this.svo = svo;
	}
	
	

}
