package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.messages.ResultMessages;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	
	JobSeekerDao jobSeekerDao;

	@Autowired
	public JobSeekerManager (JobSeekerDao jobSeekerDao) {
		
		this.jobSeekerDao=jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult(this.jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(ResultMessages.jobSeekerAdded);
	}
	
	
	
}
