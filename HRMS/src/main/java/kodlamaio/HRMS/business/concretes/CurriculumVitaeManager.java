package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.CurriculumVitaeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.HRMS.entities.concretes.CurriculumVitae;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

	
	private CurriculumVitaeDao curriculumVitaeDao;
	
	@Autowired
	public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao) {
		this.curriculumVitaeDao = curriculumVitaeDao;
	}

	@Override
	public DataResult<List<CurriculumVitae>> getAll() {
		return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAll());
	}

	@Override
	public Result add(CurriculumVitae curriculumVitae) {
		this.curriculumVitaeDao.save(curriculumVitae);
		return new SuccessResult("CV is added");
	}

	@Override
	public DataResult<CurriculumVitae> findById(int id) {
		return new SuccessDataResult<CurriculumVitae>(this.curriculumVitaeDao.getById(id));
	}

}
