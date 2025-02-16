package in.ashokit.rest;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Plan;
import in.ashokit.service.PlanService;

@RestController
public class PlanRestController {
	
	@Autowired
	private PlanService planService;
	
	
//	@GetMapping("/categories")
//	public ResponseEntity<Map<Integer,String>> planCategories(){
//		
//		planService.get
//		return null;
//		
//	}
	
	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan)
	{
		String responseMsg="";
		boolean isSaved = planService.savePlan(plan);
		if(isSaved)
		{
		    responseMsg="Plan saved";	
		}
		else
		{
			responseMsg="plan not saved";
		}
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {
	    Map<Integer, String> categories = planService.getPlanCategories();
	    return new ResponseEntity<>(categories, HttpStatus.OK);
	}
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> plans(){
		List<Plan> allPlans = planService.getAllPlans();
		return new ResponseEntity<>(allPlans,HttpStatus.OK);	
	}
	
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId){
		Plan planById = planService.getPlanById(planId);
		
		return new ResponseEntity<>(planById,HttpStatus.OK);
		
	}
	

}
