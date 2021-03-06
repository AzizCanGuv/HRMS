package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

public interface JobSeekerService {

	DataResult <List<JobSeeker>> getAll();
	Result add(JobSeeker jobSeeker);
	
	DataResult<JobSeeker>  findById(int id);
}
