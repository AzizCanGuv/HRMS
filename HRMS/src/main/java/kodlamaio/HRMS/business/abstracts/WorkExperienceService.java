package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;

import kodlamaio.HRMS.entities.concretes.WorkExperience;

public interface WorkExperienceService {
	DataResult <List<WorkExperience>> getAll();
	Result add(WorkExperience workExperience);
}
