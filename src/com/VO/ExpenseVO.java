package com.VO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Expense")

public class ExpenseVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int ID;
	@Column
	private String Expense;
	@Column
	private String Remark;
	@Column
	private String Balance;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getExpense() {
		return Expense;
	}
	public void setExpense(String expense) {
		Expense = expense;
	}
	
	public String getRemark() {
		return Remark;
	}
	public void setRemark(String remark) {
		Remark = remark;
	}
	public String getBalance() {
		return Balance;
	}
	public void setBalance(String balance) {
		Balance = balance;
	}
	
	

}
