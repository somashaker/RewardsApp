package com.reward.program.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.reward.program.service.RewardsService;

import lombok.extern.slf4j.Slf4j;
import com.reward.program.model.RewardResponse;
import com.fasterxml.*;

@Slf4j
@RestController
public class RewardRequestsHandler {
	
	@Autowired
	RewardsService rewardsService;

	@PostMapping
	@RequestMapping("/calculaterewards")
	public String calculateRewards(@RequestParam String cname,@RequestParam int dollars) {
		rewardsService.calculateRewards(cname,dollars);
		return "calculated rewards";
	}
	
	@GetMapping(produces=MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping("/getrewards")
	public ResponseEntity<RewardResponse> getRewards(@RequestParam String startMonth,@RequestParam String endMonth) {
		return new ResponseEntity(rewardsService.getPoints(startMonth,endMonth),HttpStatus.OK);
		
	}
	
}
