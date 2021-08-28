package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;


@RestController
@RequestMapping("api/jobadvertisements")
public class JobAdvertisementControllers {
	
	private JobAdvertisementService jobAdvertisementService;

	@Autowired
	public JobAdvertisementControllers(JobAdvertisementService jobAdvertisementService) {	
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}
	@GetMapping("/getall")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
		
	}
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
		return this.jobAdvertisementService.add(jobAdvertisement);
	}
	@GetMapping("/getbyid")
	public DataResult<List<JobAdvertisement>> getById(int jobAdvertisementId){
		return this.jobAdvertisementService.getById(jobAdvertisementId);
		
	}
	@GetMapping("/getbyjobadvertisementname")
	public DataResult<List<JobAdvertisement>> getByJobAdvertisementName(String jobAdvertisementName){
		return this.jobAdvertisementService.getByJobAdvertisementName(jobAdvertisementName);
		
	}
	

}
