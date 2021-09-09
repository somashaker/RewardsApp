package com.reward.program.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.reward.program.model.CustomerResponse;
import com.reward.program.model.RewardProgram;
import com.reward.program.model.RewardResponse;

import lombok.extern.slf4j.Slf4j;
import com.reward.program.repository.RewardProgramRepository;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
@Component
@Slf4j
public class RewardsService {
	
	@Autowired
	RewardProgramRepository rewardProgramRepository;
	
	public void calculateRewards(String cname,int dollars) {
		
		int points = dollars>100 ? ((dollars-100)*2)+50:(dollars>100 ?dollars-50:0);
		String consDate = LocalDate.now().getYear()+"-"+LocalDate.now().getMonthValue()+"-"+LocalDate.now().getDayOfMonth();
		RewardProgram rewardProgram = new RewardProgram(cname,points,dollars,LocalDate.now().getMonthValue(),consDate);
		
		rewardProgramRepository.save(rewardProgram);
		System.out.println(rewardProgramRepository.findAll());
		
	}
	
	public String getPoints(String startMonth,String endMonth) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonResponse=null;
		try {
		String startDate = getDateForMonth(startMonth);
		String endDate = getDateForMonth(endMonth);
		List<RewardProgram> rewardList = rewardProgramRepository.getRewards(startDate,endDate);
		
		RewardResponse rewardsResponse = new RewardResponse();
		rewardsResponse.setStartMonth(startMonth);
		rewardsResponse.setEndMonth(endMonth);
		
		Map<String,Integer> sumMapByCust = rewardList.stream().collect( Collectors.groupingBy(reward -> reward.getCustomerName(),
				Collectors.summingInt(reward-> reward.getRewardPoints())));
		
		Map<String, List<RewardProgram>> cnameGrouped =
				rewardList.stream().collect(Collectors.groupingBy(w -> w.getCustomerName()));
		
		Set<String> cnameSet = cnameGrouped.keySet();
		
		Iterator<String> rewarditer = cnameSet.iterator();
		
		List<CustomerResponse> custList = new ArrayList<CustomerResponse>();
		
		while(rewarditer.hasNext()) {
			CustomerResponse cusr = new CustomerResponse();
			String rp = rewarditer.next();
			cusr.setCustomerName(rp);
			List<RewardProgram> listPgm = cnameGrouped.get(rp);
			Map<String,Integer> sumMapByMonth = listPgm.stream().collect( Collectors.groupingBy(reward -> getMonth(reward.getTransactionMonth()),
					Collectors.summingInt(reward-> reward.getRewardPoints())));
			cusr.setMonthMap(sumMapByMonth);
			cusr.setTotal(sumMapByCust.get(rp));
			custList.add(cusr);
		 }
		
		
		rewardsResponse.setCustomerResponse(custList);
		jsonResponse = mapper.writeValueAsString(rewardsResponse);
		
		}catch(Exception e) {
			System.out.println("Exception occured. " +e.getMessage());
		}
		
		
		return jsonResponse;
	}
	
	private String getMonth(int i) {
		String month = null;
		switch(i)
		{
			case 1: month= "January";break;
			case 2: month= "February";break;
			case 3: month= "March";break;
			case 4: month= "Apr";break;
			case 5: month= "May";break;
			case 6: month= "June";break;
			case 7: month= "July";break;
			case 8: month= "August";break;
			case 9: month= "Spetember";break;
			case 10: month= "October";break;
			case 11: month= "November";break;
			case 12: month= "December";break;
		}
		return month;
	}
	
	private String getDateForMonth(String month) throws DateTimeException, ParseException {
		int currentYear = LocalDate.now().getYear();
		String formattedDate = "01";
		
		switch(month)
		{
			case "JAN" : formattedDate = currentYear+"-01-"+formattedDate;break;
			case "FEB" : formattedDate = currentYear+"-02-"+formattedDate;break;
			case "MAR" : formattedDate = currentYear+"-03-"+formattedDate;break;
			case "APR" : formattedDate = currentYear+"-04-"+formattedDate;break;
			case "MAY" : formattedDate = currentYear+"-05-"+formattedDate;break;
			case "JUN" : formattedDate = currentYear+"-06-"+formattedDate;break;
			case "JUL" : formattedDate = currentYear+"-07-"+formattedDate;break;
			case "AUG" : formattedDate = currentYear+"-08-"+formattedDate;break;
			case "SEP" : formattedDate = currentYear+"-01-"+formattedDate;break;
			case "OCT" : formattedDate = formattedDate+"10-"+currentYear;break;
			case "NOV" : formattedDate = formattedDate+"11-"+currentYear;break;
			case "DEC" : formattedDate = formattedDate+"12-"+currentYear;break;
			default : throw new DateTimeException("provided invalid month");
		}
		
		return formattedDate;
	}

}
