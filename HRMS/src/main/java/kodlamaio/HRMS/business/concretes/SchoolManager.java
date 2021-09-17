package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.SchoolService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorDataResult;
import kodlamaio.HRMS.core.utilities.results.ErrorResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SchoolDao;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.concretes.School;
import net.bytebuddy.asm.Advice.This;

@Service
public class SchoolManager implements SchoolService{

	private SchoolDao  schoolDao;
	
	
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao) {
		this.schoolDao = schoolDao;
	}

	@Override
	public DataResult<List<School>> getAll() {
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll());
	}

	@Override
	public Result add(School school) {
		if(school.isGraduated()) {
			if(school.getSchoolPeriodEnd()==null) {
				return new ErrorResult("You must enter graduation date");
			}	
		}
		this.schoolDao.save(school);
		
		return new SuccessResult("School is added");
	}
	
	
	@Override
	public DataResult<List<School>> getAllByDateSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"schoolPeriodEnd");
		return new SuccessDataResult<List<School>>(this.schoolDao.findAll(sort));
	}

}
