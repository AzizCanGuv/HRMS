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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ComputerKnowledgeService;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ComputerKnowledge;

@RestController
@RequestMapping("/api/computerknowledges")
public class ComputerKnowledgeControllers {


	private ComputerKnowledgeService computerKnowledgeService;
	@Autowired
	public ComputerKnowledgeControllers(ComputerKnowledgeService computerKnowledgeService) {
		this.computerKnowledgeService=computerKnowledgeService;  
	}  
	
	@GetMapping("/getAll")
	DataResult<List<ComputerKnowledge>> getAll(){
		return this.computerKnowledgeService.getAll();
	}
	
	@PostMapping("/add")
	Result add (@RequestBody ComputerKnowledge computerKnowledge) {
		return this.computerKnowledgeService.add(computerKnowledge);
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
