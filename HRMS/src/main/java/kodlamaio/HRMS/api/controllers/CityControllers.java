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

import kodlamaio.HRMS.business.abstracts.CityService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.City;

@RestController
@RequestMapping("api/cities")
public class CityControllers {

	CityService cityService;

	@Autowired
	public CityControllers(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	@GetMapping("/getall")
	public DataResult<List<City>> getAll() {
		return this.cityService.getAll();
	}
	@GetMapping("/getById")
	public DataResult getById(int cityId) {
		return this.cityService.getById(cityId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody City city) {
		return this.cityService.add(city);
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
