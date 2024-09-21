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
@Table(name = "PLAN_MASTER")
public class Plan {

	@Id
	@GeneratedValue
	@Column(name = "PLAN_ID")
	private Integer planId;

	@Column(name = "PLAN_NAME")
	private String planName;

	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;

	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;

	@Column(name = "ACTIVE_SW")
	private String activeSw;

	@Column(name = "PLAN_CATEGEORY_ID")
	private Integer planCategoryId;

	@Column(name = "CREATED_BY")
	private String createBy;

	@Column(name = "UPDATE_BY")
	private String updateBy;

	@Column(name = "CREATED_DATE")
	@CreationTimestamp
	private LocalDate createdate;

	@Column(name = "UPDATE_DATE")
	@UpdateTimestamp
	private LocalDate updatedate;

}
