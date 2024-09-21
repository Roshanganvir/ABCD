package com.ashok.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashok.entity.Plan;
import com.ashok.entity.PlanCategory;
import com.ashok.repo.PlanCategoryRepo;
import com.ashok.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

	@Autowired
	private PlanRepo planRepo;

	@Autowired
	private PlanCategoryRepo plancategoryRepo;

	@Override
	public Map<Integer, String> getPlanCategories() {

		List<PlanCategory> categories = plancategoryRepo.findAll();

		Map<Integer, String> categoriesMap = new HashMap<>();

		categories.forEach(categorie -> {
			categoriesMap.put(categorie.getCategoryId(), categorie.getCategoryName());
		});

		return categoriesMap;
	}

	@Override
	public boolean savePlan(Plan plan) {

		Plan saved = planRepo.save(plan);

		return saved.getPlanId() != null;
	}

	@Override
	public List<Plan> getAllPlan() {

		return  planRepo.findAll();

		
	}

	@Override
	public Plan getPlanById(Integer planId) {

		Optional<Plan> FindByid = planRepo.findById(planId);
		if (FindByid.isPresent()) {
			return FindByid.get();
		}

		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {

		 planRepo.save(plan);

		return plan.getPlanId() != null;
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status = false;

		try {

			planRepo.deleteById(planId);
			return true;

		} catch (Exception e) {
			e.printStackTrace();

		}

		return false;
	}

	@Override
	public boolean planStatusChange(Integer id, String status) {

		Optional<Plan> findBYid = planRepo.findById(id);

		if (findBYid.isPresent()) {
			Plan plan = findBYid.get();
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;
		}

		return false;
	}

}
