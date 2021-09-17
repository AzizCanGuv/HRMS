package kodlamaio.HRMS.api.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.WorkExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
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
	@GetMapping("getallbydatedesc")
	public DataResult<List<WorkExperience>> getAllByDateSortedDESC() {
		return this.workExperienceService.getAllByDateSortedDESC();
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
