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
	public JobSeekerManager (JobSeekerDao jobSeekerDao) {
		
		this.jobSeekerDao=jobSeekerDao;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult(this.jobSeekerDao.findAll());
	}

	@Override
	public Result add(JobSeeker jobSeeker) {
		
		
		// Is email Exists ve is Id number exists metodlari findByNationalIdentity ve findByEmail ile degistirelilecek
		
		
		/*if(jobSeeker.getIdentityNumber() == null || jobSeeker.getBirthOfYear() == null ||jobSeeker.getName() == null ||
				jobSeeker.getPassword() == null || jobSeeker.getPassword_again()==null || jobSeeker.getSurname()==null) {
			return new ErrorResult("You have to fill all the informations");
		}else if(!jobSeeker.getPassword().equals(jobSeeker.getPassword_again())) {
			return new ErrorResult("Passwords don't match");
		}else if( jobSeekerVerificationService.isIdNumberExists(jobSeeker.getIdentityNumber())) {
			return new ErrorResult("ID number is already exists");
		}else if(!emailVerificationService.isEmailExists(jobSeeker.getEmail())||
				!emailVerificationService.isEmailFormatCorrect(jobSeeker.getEmail())|| 
				!emailVerificationService.isEmailVerified(jobSeeker.getEmail())) {
			return new ErrorResult("Email is wrong");
		}else {
			
		}*/
		
		this.jobSeekerDao.save(jobSeeker);
		return new SuccessResult(ResultMessages.jobSeekerAdded);
		
	}
	
	
	
}
