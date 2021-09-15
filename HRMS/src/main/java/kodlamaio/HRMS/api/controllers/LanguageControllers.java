package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.LanguageService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;

import kodlamaio.HRMS.entities.concretes.Language;

@RestController
@RequestMapping("/api/languages")
public class LanguageControllers {

	private LanguageService languageService;
	@Autowired
	public LanguageControllers(LanguageService languageService) {
		this.languageService=languageService;  
	}  
	
	@GetMapping("/getAll")
	DataResult<List<Language>> getAll(){
		return this.languageService.getAll();
	}
	
	@PostMapping("/add")
	Result add (@RequestBody Language language) {
		return this.languageService.add(language);
	}
}
