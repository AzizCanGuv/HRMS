package kodlamaio.HRMS.business.abstracts;


import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;



public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAllByDateSortedASC();
	
	DataResult<List<JobAdvertisement>> getAllByDateSortedDESC();
	
	public DataResult<List<JobAdvertisement>> getAll();
	
	public Result add(JobAdvertisement jobAdvertisement);
	
	public DataResult findById(int jobAdvertisementId);
	
	public DataResult<List<JobAdvertisement>> findByStatusTrue();
	
	public Result setActiveStatus(boolean status, int id);
	
	public Result setMinMaxSalary(int id,double minimumSalary, double maximumSalary);
	//public DataResult<List<JobAdvertisement>> findByStartDateBetween(Date startDate, Date endDate);

}

