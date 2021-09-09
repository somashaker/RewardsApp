package com.reward.program.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CustomerResponse {
	
	@JsonProperty
	String customerName;
	@JsonProperty
	Map<String,Integer> monthMap;
	@JsonProperty
	int total;
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public Map<String, Integer> getMonthMap() {
		return monthMap;
	}
	public void setMonthMap(Map<String, Integer> monthMap) {
		this.monthMap = monthMap;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	

}
