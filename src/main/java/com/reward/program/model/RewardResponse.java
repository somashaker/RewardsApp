package com.reward.program.model;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class RewardResponse {
	
	@JsonProperty
	String startMonth;
	@JsonProperty
	String endMonth;
	@JsonProperty
	List<CustomerResponse> customerResponse;

	public String getStartMonth() {
		return startMonth;
	}

	public void setStartMonth(String startMonth) {
		this.startMonth = startMonth;
	}

	public String getEndMonth() {
		return endMonth;
	}

	public void setEndMonth(String endMonth) {
		this.endMonth = endMonth;
	}

	public List<CustomerResponse> getCustomerResponse() {
		return customerResponse;
	}

	public void setCustomerResponse(List<CustomerResponse> customerResponse) {
		this.customerResponse = customerResponse;
	}
	
	
	
	
	
}
