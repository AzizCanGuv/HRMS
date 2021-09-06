package kodlamaio.HRMS.business.concretes;

import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.JobAdvertisementService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService{

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		
		this.jobAdvertisementDao = jobAdvertisementDao;
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisement added");
	}

	@Override
	public DataResult findById(int jobAdvertisementId) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getById(jobAdvertisementId));
	}

	@Override
	public DataResult<List<JobAdvertisement>> findByStatusTrue() {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStatusTrue());
	}

	/*@Override
	public DataResult<List<JobAdvertisement>> findByStartDateBetween(Date startDate, Date endDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findByStartDateBetween(startDate, endDate));
	}*/

	@Override
	public DataResult<List<JobAdvertisement>> getAllByDateSortedASC() {
		Sort sort = Sort.by(Sort.Direction.ASC,"startDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}

	@Override
	public DataResult<List<JobAdvertisement>> getAllByDateSortedDESC() {
		Sort sort = Sort.by(Sort.Direction.DESC,"startDate");
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll(sort));
	}

	
	

	public Result setActiveStatus(boolean status, int id) {
		JobAdvertisement jobAdvertisement = new JobAdvertisement();
		jobAdvertisement = this.jobAdvertisementDao.getById(id);
		jobAdvertisement.setStatus(status);
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return 	new SuccessResult("Status has changed");
	}

	@Override
	public Result setMinMaxSalary(int id,double minimumSalary, double maximumSalary) {
		JobAdvertisement jobAdvertisement = this.jobAdvertisementDao.getById(id);
		jobAdvertisement.setMinimumSalary(minimumSalary);
		jobAdvertisement.setMaximumSalary(maximumSalary);
		
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Minimum and maximum salary changed");
	}

	
	

	
	
	
	
}
