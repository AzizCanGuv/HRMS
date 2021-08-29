package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.City;

public interface CityService {

	public DataResult<List<City>> getAll();
	
	public Result add(City city);
	
	public DataResult getById(int cityId);
	
	
}
