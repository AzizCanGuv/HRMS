package kodlamaio.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.HRMS.business.abstracts.ProjectService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;

import kodlamaio.HRMS.entities.concretes.Project;

@RestController
@RequestMapping("/api/projects")
public class ProjectControllers {

	private ProjectService projectService;
	@Autowired
	public ProjectControllers(ProjectService projectService) {
		this.projectService=projectService;  
	}  
	
	@GetMapping("/getAll")
	DataResult<List<Project>> getAll(){
		return this.projectService.getAll();
	}
	
	@PostMapping("/add")
	Result add (@RequestBody Project project) {
		return this.projectService.add(project);
	}
}
