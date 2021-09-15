package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.ComputerKnowledgeService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.ComputerKnowledgeDao;

import kodlamaio.HRMS.entities.concretes.ComputerKnowledge;

@Service
public class ComputerKnowledgeManager implements ComputerKnowledgeService{
	ComputerKnowledgeDao computerKnowledgeDao;
	@Autowired
	public ComputerKnowledgeManager(ComputerKnowledgeDao computerKnowledgeDao) {
		this.computerKnowledgeDao = computerKnowledgeDao;
	}
	@Override
	public DataResult<List<ComputerKnowledge>> getAll() {
		return new SuccessDataResult<List<ComputerKnowledge>>(this.computerKnowledgeDao.findAll());
	}

	@Override
	public Result add(ComputerKnowledge computerKnowledge) {
		this.computerKnowledgeDao.save(computerKnowledge);
		return new SuccessResult("Computer knowledge added");
	}

}
