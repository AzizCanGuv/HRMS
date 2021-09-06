package kodlamaio.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.HRMS.entities.concretes.JobSeeker;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer>{

	
	
	JobSeeker findByIdentityNumber(String identityNumber);
	JobSeeker findByEmail (String email);
	
}
