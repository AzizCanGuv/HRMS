package kodlamaio.HRMS.business.abstracts;

import java.util.List;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.entities.concretes.SocialLink;

public interface SocialLinkService {

	DataResult<List<SocialLink>> getAll();
	Result add(SocialLink socialLink);
	DataResult<SocialLink> findById(int id);

	
}
