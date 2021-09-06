package kodlamaio.HRMS.api.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public DataResult<JobAdvertisement> getById(int jobAdvertisementId){
		return this.jobAdvertisementService.findById(jobAdvertisementId);
		
	}
    
    @GetMapping("/getallbyjobadvertisementstatustrue")
	public DataResult<List<JobAdvertisement>> getallByJobAdvertisementStatusTrue(){
		return this.jobAdvertisementService.findByStatusTrue();
		
	}
    /*@GetMapping("/getallbydates")
    public DataResult<List<JobAdvertisement>> findByStartDateBetween(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate){
    	return this.jobAdvertisementService.findByStartDateBetween(startDate, endDate);
    }*/
    
    @GetMapping("/getallbydateasc")
    public DataResult<List<JobAdvertisement>> findByStartDateSortedASC(){
    	return this.jobAdvertisementService.getAllByDateSortedASC();
    }
    @GetMapping("/getallbydatedesc")
    public DataResult<List<JobAdvertisement>> findByStartDateSortedDESC(){
    	return this.jobAdvertisementService.getAllByDateSortedDESC();
    }
    
    @PostMapping("/setstatus")
	public Result setStatus( boolean status, int id) {
    	return this.jobAdvertisementService.setActiveStatus(status, id);
    	
    }
    @PostMapping("/changeMinMax")
	public Result setMinMaxSalary(int id, double minimumSalary,double maximumSalary) {
    	return this.jobAdvertisementService.setMinMaxSalary(id, minimumSalary, maximumSalary);
    }

}
