package kodlamaio.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.HRMS.entities.concretes.ComputerKnowledge;

public interface ComputerKnowledgeDao extends JpaRepository<ComputerKnowledge,Integer>{

}
