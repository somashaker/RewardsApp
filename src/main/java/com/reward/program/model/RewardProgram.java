package com.reward.program.model;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Entity
@Data
@Table(name="rewardprogram")
public class RewardProgram {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "reward_points")
	private int rewardPoints;

	@Column(name = "amount_spent")
	private int amountSpent;
	
	@Column(name = "transaction_date")
	private String transactionDate;
	

	@Column(name = "trn_month")
	private int transactionMonth;
	
	
	@Override
	public String toString() {
		return "RewardProgram [id=" + id + ", customerName=" + customerName + ", rewardPoints=" + rewardPoints
				+ ", amountSpent=" + amountSpent + ", transactionDate=" + transactionDate + ", transactionMonth="
				+ transactionMonth + "]";
	}
	RewardProgram(){
		
	}
	public RewardProgram(String customerName,int rewardPoints,int amountSpent,int transactionMonth,String transactionDate) {
		this.customerName=customerName;
		this.rewardPoints=rewardPoints;
		this.amountSpent=amountSpent;
		this.transactionMonth=transactionMonth;
		this.transactionDate=transactionDate;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(int rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public int getAmountSpent() {
		return amountSpent;
	}
	public void setAmountSpent(int amountSpent) {
		this.amountSpent = amountSpent;
	}
	public String getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
	}
	public int getTransactionMonth() {
		return transactionMonth;
	}
	public void setTransactionMonth(int transactionMonth) {
		this.transactionMonth = transactionMonth;
	}
	

	
	
}
