package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CurriculumVitae;
import kodlamaio.HRMS.entities.concretes.JobSeeker;

public interface CurriculumVitaeService {

	
	public DataResult<List<CurriculumVitae>> getAll();
	
	public Result add(CurriculumVitae curriculumVitae);
	
	DataResult<CurriculumVitae>  findById(int id);
}
