package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

	
	
    List<JobAdvertisement> findByStatusTrue();
	//List<JobAdvertisement> findByStartDateBetween(Date startDate, Date endDate);
	
    
    
}
