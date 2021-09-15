package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.WorkExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;

import kodlamaio.HRMS.entities.concretes.WorkExperience;

@RestController
@RequestMapping("/api/workexperiences")
public class WorkExperienceControllers {
	
	private WorkExperienceService workExperienceService;
	@Autowired
	public WorkExperienceControllers(WorkExperienceService workExperienceService) {
		this.workExperienceService=workExperienceService;  
	}  
	
	@GetMapping("/getAll")
	DataResult<List<WorkExperience>> getAll(){
		return this.workExperienceService.getAll();
	}
	
	@PostMapping("/add")
	Result add (@RequestBody WorkExperience workExperience) {
		return this.workExperienceService.add(workExperience);
	}
}
