package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobSeekerService;
import kodlamaio.HRMS.business.messages.ResultMessages;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.core.verification.abstracts.EmailVerificationService;
import kodlamaio.HRMS.core.verification.abstracts.JobSeekerVerificationService;
import kodlamaio.HRMS.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private JobSeekerVerificationService jobSeekerVerificationService;
	private EmailVerificationService emailVerificationService;

	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao) {

		this.jobSeekerDao = jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult(this.jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeeker jobSeeker) {

		if (jobSeeker.getBirthOfYear() == null || jobSeeker.getEmail() == null || jobSeeker.getIdentityNumber() == null
				|| jobSeeker.getName() == null || jobSeeker.getPassword() == null
				|| jobSeeker.getPasswordAgain() == null || jobSeeker.getSurname() == null) {

			return new ErrorResult("At least one field is not filled");
			
		} else if (jobSeeker.getPassword() == jobSeeker.getPasswordAgain()) {
			
			return new ErrorResult("Passwords are not same");
			
		} else if (this.jobSeekerDao.findByIdentityNumber(jobSeeker.getIdentityNumber()) != null || this.jobSeekerDao.findByEmail(jobSeeker.getEmail()) != null) {

			return new ErrorResult("Email or Identity Number is already exists");
			
		}

		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(ResultMessages.jobSeekerAdded);

	}

	@Override
	public DataResult<JobSeeker> findById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));
	}

}
