package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.HRMS.business.abstracts.SkillService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;

import kodlamaio.HRMS.entities.concretes.Skill;

@RestController
@RequestMapping("/api/skills")
public class SkillControllers {

	
	private SkillService skillService;
	@Autowired
	public SkillControllers(SkillService skillService) {
		this.skillService=skillService;  
	}  
	
	@GetMapping("/getAll")
	DataResult<List<Skill>> getAll(){
		return this.skillService.getAll();
	}
	
	@PostMapping("/add")
	Result add (@RequestBody Skill skill) {
		return this.skillService.add(skill);
	}
	
	
}
