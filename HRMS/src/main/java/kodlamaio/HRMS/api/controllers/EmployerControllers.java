package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.EmployerService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerControllers {

	private EmployerService employerService;
	@Autowired
	public EmployerControllers(EmployerService employerService) {
		this.employerService=employerService;
	}
	
	@GetMapping("/getAll")
	DataResult<List<Employer>> getAll(){
		return this.employerService.getAll();
	}
	
	@PostMapping("/add")
	Result add (@RequestBody Employer employer) {
		return this.employerService.add(employer);
	}
	
	
}
