package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.School;

public interface SchoolService {

	DataResult<List<School>> getAll();
	
	Result add(School school);

	DataResult<List<School>> getAllByDateSortedDESC();
	
	
}
