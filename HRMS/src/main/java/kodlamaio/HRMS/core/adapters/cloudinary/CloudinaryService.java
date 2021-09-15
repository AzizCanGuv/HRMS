package kodlamaio.HRMS.core.adapters.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;

public interface CloudinaryService {


	public Result sendFile(MultipartFile file) throws IOException;
	
	//public Result delete(String id) throws IOException;
	
	
	
	
	         
}
