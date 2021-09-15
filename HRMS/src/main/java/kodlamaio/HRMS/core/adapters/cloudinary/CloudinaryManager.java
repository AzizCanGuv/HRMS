package kodlamaio.HRMS.core.adapters.cloudinary;

import java.io.IOException;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

import kodlamaio.HRMS.core.utilities.results.Result;
import kodlamaio.HRMS.core.utilities.results.SuccessDataResult;

@Service
public class CloudinaryManager implements CloudinaryService {
	
	
	
	static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
			"cloud_name", "dysvnd3gl",
			"api_key", "558815482955266",
			"api_secret", "K0XDMfQ8aiBUNFUzxU4Hrd5-Wq4"));
	



	@Override
	public Result sendFile(MultipartFile file) throws IOException {
		Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
	
		return new SuccessDataResult<Map<String,String>>(uploadResult.toString());
	}
/*
	@Override
	public Result delete(String id) throws IOException {
		Map deleteResult = cloudinary.uploader().destroy(id,  ObjectUtils.emptyMap());
		return new SuccessResult(deleteResult.toString());
		
	}*/
}
