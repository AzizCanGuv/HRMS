package kodlamaio.HRMS.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.HRMS.business.abstracts.SocialLinkService;
import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;
import kodlamaio.HRMS.core.utilities.results.SuccessResult;
import kodlamaio.HRMS.dataAccess.abstracts.SocialLinkDao;
import kodlamaio.HRMS.entities.concretes.SocialLink;

@Service
public class SocialLinkManager implements SocialLinkService {

	private SocialLinkDao socialLinkDao;
	
	
	@Autowired
	public SocialLinkManager(SocialLinkDao socialLinkDao) {
		super();
		this.socialLinkDao = socialLinkDao;
	}

	@Override
	public DataResult<List<SocialLink>> getAll() {
		return new SuccessDataResult<List<SocialLink>>(this.socialLinkDao.findAll());
	}

	@Override
	public Result add(SocialLink socialLink) {
		this.socialLinkDao.save(socialLink);
		return new SuccessResult("Social link added");
	}

	@Override
	public DataResult<SocialLink> findById(int id) {
		return new SuccessDataResult<SocialLink>(this.socialLinkDao.getById(id));
	}
	
	

}
