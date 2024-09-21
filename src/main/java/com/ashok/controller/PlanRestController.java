package com.ashok.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ashok.entity.Plan;
import com.ashok.service.PlanService;

@RestController
public class PlanRestController {

	@Autowired
	private PlanService planService;

	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {

		Map<Integer, String> categories = planService.getPlanCategories();
		return new ResponseEntity<>(categories, HttpStatus.OK);

	}

	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {

		String responseMsg = " ";

		boolean isSaved = planService.savePlan(plan);

		if (isSaved) {
			responseMsg = "Plan is Saved";
		} else {
			responseMsg = "plan NOt Saved";
		}
		return new ResponseEntity<>(responseMsg, HttpStatus.CREATED);

	}

	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plan() {
		List<Plan> allPlan = planService.getAllPlan();
		return new ResponseEntity<>(allPlan, HttpStatus.OK);
	}

	@PostMapping("/plan/{update}")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {

		boolean isUpdate = planService.updatePlan(plan);

		String msg = "";

		if (isUpdate) {
			msg = "Plan update";
		} else {
			msg = "Plan is not update";
		}
		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deltePlan(@PathVariable Integer planId) {

		boolean isDeleted = planService.deletePlanById(planId);

		String msg = "";

		if (isDeleted) {
			msg = "Plan Deleted";
		} else {
			msg = "plan NOt deleted";
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);
	}

	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> statusChange(@PathVariable Integer planId, @PathVariable String status) {
		String msg = "";

		boolean isStatusChanged = planService.planStatusChange(planId, status);

		if (isStatusChanged) {
			msg = "status changed";
		} else {
			msg = "status not changed";
		}

		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

}
