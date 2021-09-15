package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.WorkExperience;

public interface WorkExperienceDao extends JpaRepository<WorkExperience,Integer> {

}
