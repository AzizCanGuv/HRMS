package kodlamaio.HRMS.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.results.DataResult;
import kodlamaio.HRMS.entities.concretes.Image;
import kodlamaio.HRMS.core.utilities.results.Result;

public interface ImageService {

	
	DataResult<List<Image>> getAll();
	
	
	
	Result add ( MultipartFile multipartFile ) throws IOException;
	
}
