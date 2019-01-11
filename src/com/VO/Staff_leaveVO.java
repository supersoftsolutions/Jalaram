package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Staff_leave")

public class Staff_leaveVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int staff_leaveid;

	@Column
	private String Date;
	
	@ManyToOne
	private StaffVO svo;

	public int getStaff_leaveid() {
		return staff_leaveid;
	}

	public void setStaff_leaveid(int staff_leaveid) {
		this.staff_leaveid = staff_leaveid;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public StaffVO getSvo() {
		return svo;
	}

	public void setSvo(StaffVO svo) {
		this.svo = svo;
	}

	
	
	


}
