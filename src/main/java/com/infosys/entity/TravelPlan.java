package com.infosys.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="NTRS01_TRAVEL_PLAN")
@Data
public class TravelPlan {

	@Id
	@Column(name = "PLAN_ID")
	@GeneratedValue(strategy=GenerationType.AUTO) 
	private Integer planId;
	
	@Column(name="PLAN_NAME",length=30)
	private String planName;
	
	@Column(name="PLAN_MIN_BUDGET")
	private Double planMinBudget;
	
	@Column(name="PLAN_DESCRIPTION",length=50)
	private String planDescription;
	
	@Column(name="PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name="CREATED_DATE",updatable=false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_DATE",updatable=true,insertable=false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	@Column(name="CREATED_BY",length=20)
	private String createdBy;
	
	@Column(name="UPDATED_BY",length=20)
	private String updatedBy;
	
	@Column(name="ACTIVE_SW",length=20)
	private String activateSW="active";

	public Integer getPlanId() {
		return planId;
	}

	public void setPlanId(Integer planId) {
		this.planId = planId;
	}

	public String getPlanName() {
		return planName;
	}

	public void setPlanName(String planName) {
		this.planName = planName;
	}

	public Double getPlanMinBudget() {
		return planMinBudget;
	}

	public void setPlanMinBudget(Double planMinBudget) {
		this.planMinBudget = planMinBudget;
	}

	public String getPlanDescription() {
		return planDescription;
	}

	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}

	public Integer getPlanCategoryId() {
		return planCategoryId;
	}

	public void setPlanCategoryId(Integer planCategoryId) {
		this.planCategoryId = planCategoryId;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public String getActivateSW() {
		return activateSW;
	}

	public void setActivateSW(String activateSW) {
		this.activateSW = activateSW;
	}

	public TravelPlan(Integer planId, String planName, Double planMinBudget, String planDescription,
			Integer planCategoryId, LocalDateTime createdDate, LocalDateTime updatedDate, String createdBy,
			String updatedBy, String activateSW) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planMinBudget = planMinBudget;
		this.planDescription = planDescription;
		this.planCategoryId = planCategoryId;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
		this.activateSW = activateSW;
	}

	@Override
	public String toString() {
		return "TravelPlan [planId=" + planId + ", planName=" + planName + ", planMinBudget=" + planMinBudget
				+ ", planDescription=" + planDescription + ", planCategoryId=" + planCategoryId + ", createdDate="
				+ createdDate + ", updatedDate=" + updatedDate + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ ", activateSW=" + activateSW + "]";
	}

	public TravelPlan() {
		super();
		// TODO Auto-generated constructor stub
	}	
}
