package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Plan;
import in.ashokit.entity.PlanCategory;
import in.ashokit.repo.PlanCategoryRepo;
import in.ashokit.repo.PlanRepo;

@Service
public class PlanServiceImpl implements PlanService {

	
	@Autowired
	private PlanRepo planRepo;
	
	@Autowired
	private PlanCategoryRepo planCategoryRepo;
	
	
	@Override
	public Map<Integer, String> getPlanCategories() {
	    List<PlanCategory> categories = planCategoryRepo.findAll();
	    Map<Integer, String> categoryMap = new HashMap<>();
	    
	    categories.forEach(c -> {
	        categoryMap.put(c.getCategoryId(), c.getCategoryName());
	    });

	    return categoryMap;
	}
//	
	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
		
		Plan saved = planRepo.save(plan);
		if(saved.getPlanId()!=null)
		{
			return true;
		}
		else
		{
		return false;
		}
	}

	@Override
	public List<Plan> getAllPlans() {
		
		return planRepo.findAll();
	}

	@Override
	public Plan getPlanById(Integer planId) {
		Optional<Plan> findById = planRepo.findById(planId);
		if(findById.isPresent()) {
			return findById.get();
			
		}
		return null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		Plan save = planRepo.save(plan);
		return plan.getPlanId()!=null;
		
	}

	@Override
	public boolean deletePlanById(Integer planId) {
		boolean status=false;
		try
		{
			planRepo.deleteById(planId);
			status=true;
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
			
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer planId, String status) {
		
		Optional<Plan> findById = planRepo.findById(planId);
		
		if(findById.isPresent())
		{
			Plan plan=findById.get();
			plan.setActiveSw(status);
			planRepo.save(plan);
			return true;
		}
		return false;
	}

	
}
