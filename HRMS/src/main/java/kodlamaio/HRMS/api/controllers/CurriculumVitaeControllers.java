package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.CurriculumVitaeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CurriculumVitae;

@RestController
@RequestMapping("api/curriculumvitaes")
public class CurriculumVitaeControllers {

	private CurriculumVitaeService curriculumVitaeService;
	
	@Autowired
	public CurriculumVitaeControllers(CurriculumVitaeService curriculumVitaeService) {
		this.curriculumVitaeService = curriculumVitaeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<CurriculumVitae>> getAll(){
		return this.curriculumVitaeService.getAll();
	}
	@PostMapping("/add")
	public Result add(@RequestBody CurriculumVitae curriculumVitae){
		return this.curriculumVitaeService.add(curriculumVitae);
	}
	

	
}
