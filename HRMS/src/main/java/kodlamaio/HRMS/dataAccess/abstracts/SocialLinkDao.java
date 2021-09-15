package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.SocialLink;

public interface SocialLinkDao extends JpaRepository<SocialLink,Integer>{

}
