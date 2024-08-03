package com.infosys.service;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.commons.AppConfigProperties;
import com.infosys.entity.PlanCategory;
import com.infosys.entity.TravelPlan;
import com.infosys.repository.IPlanCategoryRepository;
import com.infosys.repository.ITravelPlanRepository;
import com.infosys.AppConstants.TravelPlanConstants;

@Service
public class TravelPlanMgmtServiceImpl implements ITravelPlanMgmtService {
	
	@Autowired
	private ITravelPlanRepository travelPlanRepo;
	@Autowired
	private IPlanCategoryRepository planCategoryRepo;
	
	private Map<String,String> messages;
	
	@Autowired
	public TravelPlanMgmtServiceImpl(AppConfigProperties props) {
		messages = props.getMessages();
		//System.out.println("messages::"+messages);
	}
	
	@Override
	public String registerTravelPlan(TravelPlan travelPlan) {
		// TODO save the object
		TravelPlan saved= travelPlanRepo.save(travelPlan);
		/*if(saved.getPlanId()!=null)
		   return "Travel Plan is saved with id value :"+saved.getPlanId();
		else
			return "Problem in saving the TravelPlan";*/
		
		return saved.getPlanId()!=null?messages.get(TravelPlanConstants.SAVE_SUCCESS)+saved.getPlanId():messages.get(TravelPlanConstants.SAVE_FAILURE);
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
		
		return travelPlanRepo.findById(planId).orElseThrow(()-> new IllegalArgumentException(messages.get(TravelPlanConstants.FIND_BY_ID_FAILURE)));
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		
		// TODO Update Travel Plan
		//TravelPlan updated= travelPlanRepo.save(plan);
		//return updated.getPlanId()!=null?"Travel Plan is updated"+updated.getPlanId():"TravelPlan not found";
		Optional<TravelPlan> opt  = travelPlanRepo.findById(plan.getPlanId());
		if(opt.isPresent()) {
			travelPlanRepo.save(plan);
			return plan.getPlanId()+messages.get(TravelPlanConstants.UPDATE_SUCCESS);
		}
		else {
			return plan.getPlanId()+messages.get(TravelPlanConstants.UPDATE_FAILURE);
		}
	}
	
	@Override
	public String deleteTravelPlan(Integer planId) {
		// TODO Auto-generated method stub
		Optional<TravelPlan> opt  = travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			travelPlanRepo.deleteById(planId);
			return planId+messages.get(TravelPlanConstants.DELETE_SUCCESS);
		}
		else {
			return planId+messages.get(TravelPlanConstants.DELETE_FAILURE);
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
			return planId+messages.get(TravelPlanConstants.STATUS_CHANGE_SUCCESS);
		}
		else {
			return planId+messages.get(TravelPlanConstants.STATUS_CHANGE_FAILURE);
		}
	}

}
