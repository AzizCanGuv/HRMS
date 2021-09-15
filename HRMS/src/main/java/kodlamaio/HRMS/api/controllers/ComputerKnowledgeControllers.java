package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ComputerKnowledgeService;

import kodlamaio.HRMS.core.utilities.results.DataResult;
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
	
}
