package com.infosys.service;

import java.util.List;
import java.util.Map;

import com.infosys.entity.TravelPlan;

public interface ITravelPlanMgmtService {

	
	public String registerTravelPlan(TravelPlan  travelPlan); //save operation
	public Map<Integer,String>  getTravelPlanCategories(); //select operation
	public List<TravelPlan>  showAllTravelPlans();  //select operation
    public TravelPlan  showTravelPlanById(Integer planId); //for edit operation show existing record for editing 
    public String  updateTravelPlan(TravelPlan plan);//for edit operation form submission
    public String  deleteTravelPlan(Integer planId); // for delete operation(hard delete)
    public String  changeTravelPlanStatus(Integer planId,String status);//for soft deletion activity
    
}
