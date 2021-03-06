package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.ComputerKnowledge;

public interface ComputerKnowledgeService {
	DataResult <List<ComputerKnowledge>> getAll();
	Result add(ComputerKnowledge computerKnowledge);
}
