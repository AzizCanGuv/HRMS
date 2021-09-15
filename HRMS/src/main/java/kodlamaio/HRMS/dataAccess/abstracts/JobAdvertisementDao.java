package kodlamaio.HRMS.dataAccess.abstracts;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.HRMS.entities.concretes.JobAdvertisement;
import kodlamaio.HRMS.entities.dtos.JobAdvertisementDto;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

	
	
    List<JobAdvertisement> findByStatusTrue();
    
   // List<JobAdvertisement> findAllByStartDateLessThanEqualAndEndDateGreaterThanEqual(Date startDate, Date endDate);


    @Query("Select new kodlamaio.HRMS.entities.dtos.JobAdvertisementDto(j.id,j.maximumSalary,j.minimumSalary,j.numberOfOpenPositions,j.status,j.startDate,j.endDate,e.companyName,e.email,e.website,e.password,c.cityName,jp.jobPositionName,jp.description) "
    		+ "From JobAdvertisement j Inner Join j.employer e Inner Join j.city c Inner Join j.jobPosition jp")
    List<JobAdvertisementDto> getJobAdvertisementDetailsDto();

}
