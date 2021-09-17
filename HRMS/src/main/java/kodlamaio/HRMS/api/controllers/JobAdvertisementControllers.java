package kodlamaio.HRMS.api.controllers;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.dtos.JobAdvertisementDto;


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
  /*  @GetMapping("/getallbydatesbetween")
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
    
    @GetMapping("/getalljobadvertisementdetails")
    public DataResult<List<JobAdvertisementDto>> getAllJobAdvertisementDetails(){
    	return this.jobAdvertisementService.getAllJobAdvertisementDetails();
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)// hata oldugunda calis
	@ResponseStatus(HttpStatus.BAD_REQUEST)// metod calistiginda 500 hatasi ver
	public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
		Map<String, String> validationErrors= new HashMap<String,String>();
		
		for(FieldError fieldError: exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>(validationErrors,"Validation Errors");
		return errors;
	}
	

}
