package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobPositionService;
import kodlamaio.HRMS.entities.concretes.JobPosition;

@RestController
@RequestMapping("api/jobpositions")
public class JobPositionControllers {
	private JobPositionService jobPositionService;
	
	@Autowired
	public JobPositionControllers(JobPositionService jobPositionService) {
		super();
		this.jobPositionService = jobPositionService;
	}

	@GetMapping("/getall")
	public List<JobPosition> getAll() {
		return jobPositionService.getAll();
	}
	
	@PostMapping("/add")
	public String add(JobPosition jobPosition) {
		
		this.jobPositionService.add(jobPosition);
		return "işlem başarılı";
	}
	
	
}
