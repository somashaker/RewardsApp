package com.reward.program.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reward.program.model.RewardProgram;

@Repository
public interface RewardProgramRepository extends JpaRepository<RewardProgram,Long> {
	
String rewardsQuery ="select t from RewardProgram t where t.transactionDate >=:startDate and t.transactionDate <=:endDate ";

@Query(rewardsQuery)
public List<RewardProgram> getRewards(@Param("startDate") String startDate ,@Param("endDate") String endDate);


}
