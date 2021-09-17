package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.WorkExperienceService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;

import kodlamaio.HRMS.dataAccess.abstracts.WorkExperienceDao;

import kodlamaio.HRMS.entities.concretes.WorkExperience;
@Service
public class WorkExperienceManager implements WorkExperienceService {
	
	WorkExperienceDao workExperienceDao;
	@Autowired
	public WorkExperienceManager(WorkExperienceDao workExperienceDao) {
		this.workExperienceDao = workExperienceDao;
	}
	
	@Override
	public DataResult<List<WorkExperience>> getAll() {
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll());
	}

	@Override
	public Result add(WorkExperience workExperience) {
		if(!workExperience.isWorkExperienceStillWorking()){
			if(workExperience.getWorkExperienceEndDate()==null) {
				return new ErrorResult("You must enter work experience end date");
			}
		}
		
		this.workExperienceDao.save(workExperience);
		return new SuccessResult("Work experience added");
	}
	@Override
	public DataResult<List<WorkExperience>> getAllByDateSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"workExperienceEndDate");
		return new SuccessDataResult<List<WorkExperience>>(this.workExperienceDao.findAll(sort));
	}

}
