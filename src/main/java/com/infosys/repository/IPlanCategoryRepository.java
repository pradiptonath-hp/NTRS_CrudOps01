package com.infosys.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infosys.entity.PlanCategory;

public interface IPlanCategoryRepository extends JpaRepository<PlanCategory,Integer> {

}
