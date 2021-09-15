package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CoverLetterService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLettersControllers {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLettersControllers(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}
	@GetMapping("/getall")
	public DataResult<List<CoverLetter>> getAll(){
		return this.coverLetterService.getAll();
	}
	@GetMapping("/getbyid")
	public DataResult<CoverLetter> getById(@RequestParam int id){
		return this.coverLetterService.findById(id);
	}
	
}
