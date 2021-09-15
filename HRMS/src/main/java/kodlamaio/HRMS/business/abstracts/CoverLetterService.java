package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.CoverLetter;

public interface CoverLetterService {

	DataResult<List<CoverLetter>> getAll();
	Result add(CoverLetter coverLetter);
	DataResult<CoverLetter> findById(int id);
}
