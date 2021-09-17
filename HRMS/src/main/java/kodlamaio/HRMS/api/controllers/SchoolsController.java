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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.SchoolService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
public class SchoolsController {

	private SchoolService schoolService;

	@Autowired
	public SchoolsController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}
	@GetMapping("/getall")
	public DataResult<List<School>> getAll() {
		return this.schoolService.getAll();
	}
	@PostMapping("/add")
	public Result add(School school) {
		return this.schoolService.add(school);
	}
	@GetMapping("/getallbygraduationdatedesc")
	public DataResult<List<School>> getAllByDateSortedDESC(){	
		return this.schoolService.getAllByDateSortedDESC();
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

