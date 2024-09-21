package com.ashok.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;

	@Column(name = "category_name")
	private String categoryName;
	
	@Column(name = "activeSw")
	private String activeSw;

	@Column(name = "CREATED_BY")
	private String createdBy;
	
	@Column(name = "updateBY")
	private String updateBy;
	
	@Column(name = "CREATE_DATE")
	@CreationTimestamp
	private LocalDate createdate;
	
	@Column(name = "UPDATE_DATE")
	@UpdateTimestamp
	private LocalDate updateDate;

}
