package com.infosys.service;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.infosys.entity.PlanCategory;
import com.infosys.entity.TravelPlan;
import com.infosys.repository.IPlanCategoryRepository;
import com.infosys.repository.ITravelPlanRepository;

public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {
	@Autowired
	private ITravelPlanRepository travelPlanRepo;
	@Autowired
	private IPlanCategoryRepository planCategoryRepo;
	
	@Override
	public String registerTravelPlan(TravelPlan travelPlan) {
		// TODO save the object
		TravelPlan saved= travelPlanRepo.save(travelPlan);
		/*if(saved.getPlanId()!=null)
		   return "Travel Plan is saved with id value :"+saved.getPlanId();
		else
			return "Problem in saving the TravelPlan";*/
		
		return saved.getPlanId()!=null?"Travel Plan is saved with id value ::"+saved.getPlanId():"Problem in saving the TravelPlan";
	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		// TODO Get All travel Plan categories
		List<PlanCategory> list =planCategoryRepo.findAll();
		Map<Integer,String> categoriesMap= new HashMap<Integer,String>();
		list.forEach(category->{
					categoriesMap.put(category.getCategoryId(),category.getCategoryName());
		});
		return categoriesMap;
	}

	@Override
	public List<TravelPlan> showAllTravelPlans() {
		// TODO Auto-generated method stub
		
		return travelPlanRepo.findAll();
	}

	@Override
	public TravelPlan showTravelPlanById(Integer planId) {
		// TODO Auto-generated method stub
		/*Optional <TravelPlan> opt  = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IllegalArgumentException("plan id not found");
		}*/
		
		return travelPlanRepo.findById(planId).orElseThrow(()-> new IllegalArgumentException("TravelPlan is not found"));
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		
		// TODO Update Travel Plan
		//TravelPlan updated= travelPlanRepo.save(plan);
		//return updated.getPlanId()!=null?"Travel Plan is updated"+updated.getPlanId():"TravelPlan not found";
		Optional<TravelPlan> opt  = travelPlanRepo.findById(plan.getPlanId());
		if(opt.isPresent()) {
			travelPlanRepo.save(plan);
			return plan.getPlanId()+"is updated";
		}
		else {
			return plan.getPlanId()+"Travel Plan is not found";
		}
	}

	@Override
	public String deleteTravelPlan(Integer planId) {
		// TODO Auto-generated method stub
		Optional<TravelPlan> opt  = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			travelPlanRepo.deleteById(planId);
			return planId+"Travel Plan is deleted";
		}
		else {
			return planId+"Travel Plan is not found";
		}
	}

	@Override
	public String changeTravelPlanStatus(Integer planId, String status) {
		// TODO Auto-generated method stub
		 
		Optional<TravelPlan> opt  = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			
			TravelPlan plan =opt.get();
			plan.setActivateSW(status);
			travelPlanRepo.save(plan);
			return planId+"Travel Plan Status is Changed!";
		}
		else {
			return planId+"Travel Plan is not found for updation";
		}
	}

}
