package com.ashok.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ashok.entity.Plan;


public interface PlanService {
	
	
	public Map<Integer,String>getPlanCategories();//findAll
	
	public boolean savePlan(Plan plan);  //saved
	
	public List<Plan>getAllPlan();     //findAll
	
	
	public Plan getPlanById(Integer planId);  //findBYid
	
	public boolean updatePlan(Plan plan);  //save
	
	public boolean deletePlanById(Integer planId); //deleteByid
	
	
	public boolean planStatusChange(Integer id,String status);//findBYid
	
	

}
