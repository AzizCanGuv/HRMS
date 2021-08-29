package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;


public interface JobAdvertisementService {

	
	public DataResult<List<JobAdvertisement>> getAll();
	
	public Result add(JobAdvertisement jobAdvertisement);
	
	public DataResult findById(int jobAdvertisementId);
	
	public DataResult<List<JobAdvertisement>> findByStatusTrue();
	


}

