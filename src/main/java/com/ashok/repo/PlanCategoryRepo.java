package com.ashok.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ashok.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
