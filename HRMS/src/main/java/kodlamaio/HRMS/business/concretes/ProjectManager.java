package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ProjectService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;

import kodlamaio.HRMS.dataAccess.abstracts.ProjectDao;

import kodlamaio.HRMS.entities.concretes.Project;
@Service
public class ProjectManager implements ProjectService{

	ProjectDao projectDao;
	@Autowired
	public ProjectManager(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}
	
	
	@Override
	public DataResult<List<Project>> getAll() {
		return new SuccessDataResult<List<Project>>(this.projectDao.findAll());
	}

	@Override
	public Result add(Project project) {
		this.projectDao.save(project);
		return new SuccessResult("Project added");
	}
}
